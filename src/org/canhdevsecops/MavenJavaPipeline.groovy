package org.canhdevsecops
class MavenJavaPipeline implements Serializable {
    
    def javaVersion;

    private MavenJavaPipeline(javaVersion) {
        this.javaVersion = javaVersion
    }

    def build() {
        sh 'mvn -v'
        sh 'mvn clean package'
    }

    def test() {
        sh 'mvn test'
    }
}