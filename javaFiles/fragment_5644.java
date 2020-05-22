buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath 'com.google.gradle:osdetector-gradle-plugin:1.6.0'
    }
}

apply plugin: 'com.google.osdetector'
apply plugin: 'java'

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