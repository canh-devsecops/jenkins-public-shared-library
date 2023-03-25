#!/usr/bin/env groovy

package org.canhdevsecops

class MavenPipelineBuilder implements Serializable {
    
    def steps

    MavenPipelineBuilder(steps) {
        this.steps = steps
    }

    def build() {
        steps.sh 'mvn -v'
        steps.sh 'mvn clean package'
    }

    def test() {
        steps.sh 'mvn test'
    }
}