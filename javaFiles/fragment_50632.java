buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath "org.springframework.boot:spring-boot-gradle-plugin:1.2.4.RELEASE"
        classpath "io.spring.gradle:dependency-management-plugin:0.5.2.RELEASE"
    }
}

apply plugin: 'idea'
apply plugin: 'spring-boot'
apply plugin: 'java'
apply plugin: 'io.spring.dependency-management'

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom 'org.springframework.boot:spring-boot-starter-parent:1.2.4.RELEASE'
    }
}

ext {
    jacksonVersion = dependencyManagement.importedProperties['jackson.version']
}

dependencies {
    compile("com.fasterxml.jackson.datatype:jackson-datatype-hibernate4:$jacksonVersion")
}