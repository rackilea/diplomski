buildscript {
    repositories {
        mavenCentral()
        maven {
            url "https://plugins.gradle.org/m2/"
        }
    }
    dependencies {
        classpath 'com.google.gradle:osdetector-gradle-plugin:1.6.0'
    }
}

apply plugin: 'application'
apply plugin: 'com.google.osdetector'

ext.platform = osdetector.os == 'osx' ? 'mac' : osdetector.os == 'windows' ? 'win' : osdetector.os

sourceCompatibility = JavaVersion.VERSION_11
targetCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    compile files('libs/external-library.jar')
    compile 'org.apache.commons:commons-lang3:3.8.1'
    compile "org.openjfx:javafx-base:11:$platform"
}

compileJava {
    doFirst {
        options.compilerArgs = [
                '--module-path', classpath.asPath,
                '--add-modules', 'javafx.base'
        ]
    }
}

run {
    doFirst {
        jvmArgs = [
                '--module-path', classpath.asPath,
                '--add-modules', 'javafx.base'
        ]
    }
}

mainClassName = "com.example.project.PublicClass"

jar {
    manifest {
        attributes 'Main-Class': 'com.example.project.PublicClass'
    }
    from {
        configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }
    }
}