buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath 'me.tatarka:gradle-retrolambda:3.2.3'
    }
}

repositories {
    jcenter()
}

apply plugin: 'java'
apply plugin: 'me.tatarka.retrolambda'

retrolambda {
    jdk System.getenv("JAVA8_HOME")
    oldJdk System.getenv("JAVA7_HOME")
    javaVersion JavaVersion.VERSION_1_6
}