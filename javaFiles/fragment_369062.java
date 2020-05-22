buildscript {
    // ...
    dependencies {
        // ...
        classpath 'com.google.gms:google-services:4.2.0' // google-services plugin
    }
}

allprojects {
    // ...
    repositories {
        google() // Google's Maven repository
        // ...
    }
}