buildscript {
    repositories {
        maven { url "https://plugins.gradle.org/m2/" }
    }
    dependencies {
        // 2.9.5 for use with Gradle 4.10.3.
        classpath "io.freefair.gradle:aspectj-plugin:2.9.5"
    }
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'idea'

apply plugin: "io.freefair.aspectj.compile-time-weaving"
aspectj.version = '1.9.3'

group 'xyz.swatt'
version '1.0.0-SNAPSHOT'

sourceCompatibility = 1.8

repositories {
    mavenCentral()
}

dependencies {

    ///// SWATT ///// https://mvnrepository.com/artifact/xyz.swatt/swatt
    compile group: 'xyz.swatt', name: 'swatt', version: '1.12.0'
    aspect "xyz.swatt:swatt:1.12.0"
}