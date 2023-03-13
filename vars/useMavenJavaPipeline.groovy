import org.canhdevsecops.MavenJavaPipeline

def call(javaVersion) {
    def pipeline = new MavenJavaPipeline(javaVersion)

    node {
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
}
