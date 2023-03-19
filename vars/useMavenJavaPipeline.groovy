#!/usr/bin/env groovy

import org.canhdevsecops.MavenJavaPipeline

def call(String javaVersion) {
    def pipeline = new MavenJavaPipeline(this)

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
                    pipeline.build
                }
            }

            stage('Test') {
                agent{
                    docker {
                        image "maven:3.8-openjdk-${javaVersion}-slim"
                    }
                }
                steps {
                    pipeline.test
                }
            }
        }
    }
}
