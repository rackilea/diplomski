buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.github.jengelman.gradle.plugins:shadow:1.2.3'
    }
}

apply plugin: 'java'
apply plugin: 'application'
apply plugin: 'com.github.johnrengelman.shadow'

repositories {
    jcenter()
}

dependencies {
    compile 'com.google.guava:guava:23.0'

    testCompile 'junit:junit:4.12'
}

mainClassName = "com.github.Library"

dependencies{
    compile 'org.apache.poi:poi:3.17'
    compile 'org.apache.poi:poi-ooxml:3.17'
    compile 'org.apache.poi:poi-ooxml-schemas:3.17'
    compile 'org.springframework:spring-core:5.0.2.RELEASE'
    compile 'org.springframework:spring-context:5.0.2.RELEASE'
    compile 'org.apache.commons:commons-collections4:4.1'
    compile 'org.apache.xmlbeans:xmlbeans:2.6.0'
}

shadowJar {
    baseName = 'finder-app'
    version =  '0.1.0'
}