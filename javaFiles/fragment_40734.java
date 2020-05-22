buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath 'com.github.dcendents:android-maven-plugin:1.0'
    }
}

apply plugin: 'android-library'
apply plugin: 'android-maven'