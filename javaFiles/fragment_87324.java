buildscript {

    repositories {

        maven { url "https://oss.sonatype.org/content/repositories/releases/" }

        mavenCentral()
    }

    dependencies {

        classpath "com.android.tools.build:gradle:2.1.2"
    }
}

apply plugin: 'com.android.library'