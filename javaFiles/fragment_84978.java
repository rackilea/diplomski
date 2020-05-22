buildscript {
    repositories {
        maven {
            url uri('../repo')
        }
    }
    dependencies {
        classpath group: 'org.joefernandez',
                   name: 'MyJavaPlugin',
                version: '1.0-SNAPSHOT'
    }
}
apply plugin: 'test-plugin'

task checkitout(type: org.joefernandez.gradle.MyJavaTask) {
    println("running consumer task!")
}