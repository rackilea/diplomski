apply plugin: 'com.android.application'
android {
    compileSdkVersion XX
    buildToolsVersion "XX.0.0"
    defaultConfig {
        applicationId "com.xxxxx.xxx"
        minSdkVersion xx
        targetSdkVersion xx
        versionCode x
        versionName "x.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
    }
}


apply plugin: 'com.neenbedankt.android-apt'


dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:25.1.1'
    testCompile 'junit:junit:4.12'

    compile 'com.android.support:multidex:1.0.1'
    compile 'com.google.code.findbugs:jsr305:2.0.1'
    compile 'com.android.support:design:25.1.1'
    compile 'com.jakewharton:butterknife:8.0.1'

    apt 'com.jakewharton:butterknife-compiler:8.0.1'
    testCompile 'junit:junit:4.12'
}