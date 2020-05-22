buildscript {
    repositories{
        maven { url "https://plugins.gradle.org/m2/" }
        jcenter()
    }
    dependencies {
        classpath "net.ltgt.gradle:gradle-apt-plugin:0.3"
    }
}

repositories {
    mavenCentral()
    maven { url "https://plugins.gradle.org/m2/" }
    jcenter()
}

apply plugin: 'net.ltgt.apt'
apply plugin: 'java'
apply plugin: 'idea'

dependencies {
 compile "com.google.dagger:dagger:2.4"
 apt 'com.google.dagger:dagger-compiler:2.4'

}