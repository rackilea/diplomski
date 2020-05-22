buildscript {
    repositories {
        maven {
            url "https://plugins.gradle.org/m2/"
        }
    }
    dependencies {
        classpath "net.ltgt.gradle:gradle-apt-plugin:0.6"
    }
}
apply plugin: 'java'
apply plugin: "net.ltgt.apt"
apply plugin: "idea"

dependencies {
    // Dagger 2 and Compiler
    compile 'com.google.dagger:dagger:2.0.2'
    apt "com.google.dagger:dagger-compiler:2.0.2"
}