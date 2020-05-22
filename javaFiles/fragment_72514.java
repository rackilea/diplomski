group 'com.example'
version '1.0-SNAPSHOT'
apply plugin: 'java'
sourceCompatibility = 1.8
repositories {
   mavenCentral()
}
dependencies {
   testCompile group: 'junit', name: 'junit', version: '4.12'
}
task(runMain, dependsOn: 'classes', type: JavaExec) {
   main = 'com.example.HelloGradle'
   classpath = sourceSets.main.runtimeClasspath
}