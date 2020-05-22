buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        maven { url "https://oss.sonatype.org/content/repositories/snapshots/" }
        jcenter()
    }
    dependencies {  
        classpath 'com.android.tools.build:gradle:2.3.2'    // <- update version  
    }
}