pom {
    project {
        groupId 'com.domain.api'
        artifactId 'gs-gradle'
        version '0.1.0'
        properties {
            project {
                build {
                    sourceEncoding 'UTF-8'
                }
            }
            maven {
                compiler {
                    source '1.8'
                    target '1.8'
                }
            }
        }

        inceptionYear '2008'
        licenses {
            license {
                name 'The Apache Software License, Version 2.0'
                url 'http://www.apache.org/licenses/LICENSE-2.0.txt'
                distribution 'repo'
            }
        }
    }
}