package org.canhdevsecops
class MavenJavaPipeline implements Serializable {
    
    def steps;

    MavenJavaPipeline(steps) {
        this.steps = steps
    }

    def build() {
        sh 'mvn -v'
        sh 'mvn clean package'
    }

    def test() {
        sh 'mvn test'
    }
}