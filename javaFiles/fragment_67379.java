buildscript {
    repositories {
        if (System.getenv("RESOLVE_LOCAL")) {
            maven { url "$indexUrl/resolver-grails3" }
        } else {
            maven { url "$indexLocalUrl/resolver-grails3" }
        }
    }

    dependencies {
        classpath 'build-info-extractor:build-info-extractor-gradle:3.1.1'
        classpath group: 'org._10ne.gradle', name: 'rest-gradle-plugin, version: '0.3.1'
    }
}

apply plugin: 'org.10ne.rest'