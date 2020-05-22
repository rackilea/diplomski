group 'nl.msegers.project.services'
version parent.version

buildscript {
    ext {
        springBootVersion = "1.5.2.RELEASE"
    }
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    }
}

subprojects {
    buildscript {
        ext {
            springBootVersion = "1.5.2.RELEASE"
        }
        repositories {
            mavenCentral()
        }
        dependencies {
            classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
        }
    }
    apply plugin: 'java'
    apply plugin: 'org.springframework.boot'


    dependencies {

        compile("org.springframework.boot:spring-boot-starter-web") {
            exclude module: "spring-boot-starter-tomcat"
        }
        compile("org.springframework.boot:spring-boot-starter-jetty")
        compile("org.springframework.boot:spring-boot-starter-actuator")

        compile project(':Libraries:Models')

        testCompile 'junit:junit:4.12'
    }

    task wrapper(type: Wrapper) {
        gradleVersion = '3.1'
    }
}