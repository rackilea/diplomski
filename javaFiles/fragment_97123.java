buildscript {
    repositories {
        maven {
            url "https://plugins.gradle.org/m2/"
        }
        jcenter()
    }
    dependencies {
        classpath "com.gradle.publish:plugin-publish-plugin:0.9.4"
        classpath 'com.novoda:bintray-release:0.3.4'
    }
}

apply plugin: "com.gradle.plugin-publish"
apply plugin: 'com.jfrog.bintray'
apply plugin: 'maven-publish'
apply plugin: 'maven'
apply plugin: 'groovy'

dependencies {
    compile gradleApi()
    compile localGroovy()
}

final bintrayUser = hasProperty('bintray_user') ? property('bintray_user') : ''
final bintrayApiKey = hasProperty('bintray_api_key') ? property('bintray_api_key') : ''
final versionName = hasProperty('version_name') ? property('version_name') : ''

version = versionName

pluginBundle {
    vcsUrl = 'https://github.com/Wrdlbrnft/ProguardAnnotations'
    website = 'https://github.com/Wrdlbrnft/ProguardAnnotations'
    description = 'Makes dealing with Proguard simple and easy!'
    plugins {

        ProguardAnnotationsPlugin {
            id = 'com.github.wrdlbrnft.proguard-annotations'
            displayName = 'ProguardAnnotations'
            tags = ['android', 'proguard', 'plugin']
        }
    }
}

task sourcesJar(type: Jar, dependsOn: classes) {
    classifier = 'sources'
    from sourceSets.main.allSource
}

publishing {
    publications {
        Bintray(MavenPublication) {
            from components.java
            groupId 'com.github.wrdlbrnft'
            artifactId 'proguard-annotations'
            artifact sourcesJar
            version versionName
        }
    }
}

bintray {
    user = bintrayUser
    key = bintrayApiKey
    publications = ['Bintray']
    pkg {
        repo = 'maven'
        name = 'ProguardAnnotationsPlugin'
        userOrg = bintrayUser
        licenses = ['Apache-2.0']
        vcsUrl = 'https://github.com/Wrdlbrnft/ProguardAnnotations'
        publicDownloadNumbers = true
        version {
            name = versionName
            released = new Date()
        }
    }
}