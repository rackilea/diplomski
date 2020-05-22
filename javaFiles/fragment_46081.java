buildscript {

    repositories {
        google()
        jcenter()
        maven {
            url "https://maven.google.com"
            name 'Google'
        }
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.2.1'

     // NOTE : REMOVE IMPLEMENTATION FILES FROM HERE AND USE THEM IN DEPENDENCIES IN BUILD.GRADLE(APP).
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven {
            url "$rootDir/../node_modules/react-native/android"
        }
        maven {
            url "https://maven.google.com"
            name 'Google'
        }
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}