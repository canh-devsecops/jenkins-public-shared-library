#!/usr/bin/env groovy

import org.canhdevsecops.MavenPipelineBuilder

def call(String javaVersion) {
    def builder = new MavenPipelineBuilder(this)

    pipeline {
        agent any

        stages {
            stage('Build') {
                agent {
                    docker {
                        image "maven:3.8-openjdk-${javaVersion}-slim"
                    }
                }
                steps {
                    script {
                        builder.build()
                    }
                }
            }

            stage('Test') {
                agent{
                    docker {
                        image "maven:3.8-openjdk-${javaVersion}-slim"
                    }
                }
                steps {
                    script {
                        builder.test()
                    }
                }
            }
        }
    }
}
