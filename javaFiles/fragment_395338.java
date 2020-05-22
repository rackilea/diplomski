apply plugin: 'maven'

task createPom << {
    pom {
        project {
            groupId 'org.example'
            artifactId 'test'
            version '1.0.0'

            inceptionYear '2008'
            licenses {
                license {
                    name 'The Apache Software License, Version 2.0'
                    url 'http://www.apache.org/licenses/LICENSE-2.0.txt'
                    distribution 'repo'
                }
            }
        }
    }.writeTo("pom.xml")
}