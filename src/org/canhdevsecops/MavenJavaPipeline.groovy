package org.canhdevsecops
class MavenJavaPipeline implements Serializable {
    
    def steps;

    MavenJavaPipeline(steps) {
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