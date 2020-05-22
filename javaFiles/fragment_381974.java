I ran into this issue as well.  Basically, the issue is that mentioned jar file is no longer in jcenter.  I resolved by changing the order of search in our app build.gradle:


buildscript {
    repositories {
        maven {
            url 'https://dl.google.com/dl/android/maven2'
        }
        google()
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.1.2'
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}