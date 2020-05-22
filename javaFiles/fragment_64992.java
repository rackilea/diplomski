plugins {
    id 'java'
    id 'application'
    id 'com.github.johnrengelman.shadow' version '1.2.4'
}
mainClassName = 'com.acme.YourMainClassName'
repositories {
    mavenCentral()
}
dependencies {
    compile group: 'com.flowpowered', name: 'flow-nbt', version: '1.0.0'
    compile group: 'org.reflections', name: 'reflections', version: '0.9.10'
}