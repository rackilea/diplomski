plugins {
    id 'java'
    id 'com.github.johnrengelman.shadow' version '5.0.0'
}
group 'com.bo'
version '1.0-SNAPSHOT'
sourceCompatibility = 1.8
repositories {
    mavenCentral()
}
dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.12'
    implementation 'org.json:json:20180813'
}
shadowJar {
    baseName = project.group
    version = project.version    
    manifest {
        attributes 'Main-Class': 'com.bo.getserversecrets.GetServerSecrets'
    }
}