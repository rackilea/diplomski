plugins {
    id 'java'
    id "io.freefair.lombok" version "4.0.1"
}

lombok {
        version = "1.18.10"
}

group 'org.example'
version '1.0-SNAPSHOT'

sourceCompatibility = 1.8

repositories {
    mavenCentral()
}

dependencies {
    testCompile 'junit:junit:4.12'
}