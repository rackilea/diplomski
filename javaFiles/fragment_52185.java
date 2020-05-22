apply plugin: 'java'
apply plugin: 'idea'

sourceCompatibility = 1.8

repositories {
    mavenLocal()
    mavenCentral()
    maven { url "http://packages.confluent.io/maven/" }
}

configurations {
    all*.exclude group: 'org.slf4j', module: 'slf4j-log4j12'
    all*.exclude group: 'log4j'
}

dependencies {
    compile 'io.confluent:kafka-connect-storage-partitioner:3.2.1'
    compile 'org.apache.kafka:connect-api:0.10.2.1'

    testCompile 'junit:junit:4.+'
}

idea {
    project {
        languageLevel = '1.8'
    }
}