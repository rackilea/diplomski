apply plugin: 'maven'

    task createPom {
        pom {
            project {
                groupId GROUP_ID
                artifactId ARCTIFACT_ID
                version VERSION

                inceptionYear '2019'
                licenses {
                    license {
                        name 'MIT'
                        url 'https://github.com/vincenzopalazzo/material-ui-swing/blob/masternow/LICENSE'
                        distribution 'repo'
                    }
                }
            }
        }.writeTo("pom.xml")
    }