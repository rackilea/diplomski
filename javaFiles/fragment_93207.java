buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath "eu.appsatori:gradle-fatjar-plugin:0.3"
    }
}

apply plugin: 'eu.appsatori.fatjar'