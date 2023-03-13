import org.canhdevsecops.MavenJavaPipeline

def call(String javaVersion) {
    def pipeline = new MavenJavaPipeline(javaVersion)

    pipeline {
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
