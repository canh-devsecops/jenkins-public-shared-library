#!/usr/bin/env groovy

package org.canhdevsecops

class MavenPipelineBuilder extends AbstractPipelineBuilder {

    MavenPipelineBuilder(steps) {
        super(steps)
    }

    @Overwrite
    def build() {
        steps.sh 'mvn -v'
        steps.sh 'mvn clean package'
    }

    @Overwrite
    def test() {
        steps.sh 'mvn test'
    }
}