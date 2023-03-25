#!/usr/bin/env groovy

package org.canhdevsecops

class MavenPipelineBuilder extends AbstractPipelineBuilder {

    MavenPipelineBuilder(steps) {
        super(steps)
    }

    @Override
    def build() {
        steps.sh 'mvn -v'
        steps.sh 'mvn clean package'
    }

    @Override
    def test() {
        steps.sh 'mvn test'
    }
}