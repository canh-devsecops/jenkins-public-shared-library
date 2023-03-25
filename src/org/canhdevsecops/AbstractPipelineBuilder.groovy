package org.canhdevsecops

abstract class AbstractPipelineBuilder implements PipelineBuilder, Serializable {
    def steps

    AbstractPipelineBuilder(steps) {
        this.steps = steps
    }

    def build() {}

    def test() {}
}