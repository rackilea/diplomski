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
}.withXml {
    asNode().appendNode('build').appendNode('plugins').with {
        appendNode('plugin').with {
            appendNode('groupId', 'org.springframework.boot')
            appendNode('artifactId', 'spring-boot-maven-plugin')
            appendNode('version', "${springBootVersionDef}")
            appendNode('executions').appendNode('execution').appendNode('goals').with {
                appendNode('goal', 'repackage')
            }
        }
        appendNode('plugin').with {
            appendNode('groupId', 'org.apache.maven.plugins')
            appendNode('artifactId', 'maven-jar-plugin')
            appendNode('version', "3.0.2")
            appendNode('configuration').appendNode('archive').appendNode('manifest').with {
                appendNode('addClasspath', "true")
                appendNode('classpathPrefix', "lib/")
                appendNode('mainClass', "com.domain.api.Application")
            }
        }
    }
}.writeTo("pom.xml")