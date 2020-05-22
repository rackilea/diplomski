apply plugin: 'com.android.application'

android {
    compileSdkVersion 'android-L'
    buildToolsVersion '20.0.0'

    defaultConfig {
        applicationId "com.example"
        minSdkVersion 17
        targetSdkVersion 'L'
        versionCode 1
        versionName "1.0"
    }
    buildTypes {
        release {
            runProguard false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}

dependencies {
    apply plugin: 'findbugs'
    compile fileTree(dir: 'libs', include: ['*.jar'])
    wearApp project(':wear')
    compile 'com.google.android.gms:play-services:5.0.89'
}