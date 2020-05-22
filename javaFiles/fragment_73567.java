buildscript {
    repositories {
        maven { url 'maven repository url' }
    }

    dependencies {
        classpath group: 'gradle.plugin.com.github.spotbugs', name: 'spotbugs-gradle-plugin', version: '1.6.5'
    }
}

allprojects {

    apply plugin: 'com.github.spotbugs'

    dependencies {
        compileOnly group: 'com.github.spotbugs', name: 'spotbugs-annotations', version: '3.1.8'
        spotbugsPlugins group: 'com.h3xstream.findsecbugs', name: 'findsecbugs-plugin', version: '1.8.0'
    }

    spotbugs {
        toolVersion = '3.1.8'
        sourceSets = [ sourceSets.main ]
    }

}