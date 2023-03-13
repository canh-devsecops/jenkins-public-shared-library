import src.org.canhdevsecops.MavenJavaPipeline

def call(javaVersion) {
    def pipeline = MavenJavaPipeline(javaVersion)

    stages {
        stage('Build') {
            agent(
                docker {
                    image "3.8-openjdk-${javaVersion}-slim"
                }
            )
            steps {
                pipeline.build()
            }
        }
    }

    stages {
        stage('Build') {
            agent(
                docker {
                    image "3.8-openjdk-${javaVersion}-slim"
                }
            )
            steps {
                pipeline.test()
            }
        }
    }
}
