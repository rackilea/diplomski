task wrapper(type: Wrapper) { gradleVersion = "2.14" }


allprojects {
    repositories {
        mavenCentral()
    }
}


subprojects {
    apply plugin: 'java'
    apply plugin: 'idea'

    sourceCompatibility = 1.8

    dependencies {
        testCompile group: 'junit', name: 'junit', version: '4.11'
    }
}