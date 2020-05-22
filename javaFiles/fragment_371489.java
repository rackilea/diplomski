apply plugin: 'com.android.application'

repositories {
    jcenter()
}

android {
    compileSdkVersion 23
    buildToolsVersion "23.0.3"

    defaultConfig {
        applicationId "com.androidstack.app"
        minSdkVersion 14
        targetSdkVersion 19
        versionCode 1
        versionName "1.0"
    }
}

ext {
    supportLibVersion = '23.2.1'  // variable that can be referenced to keep support libs consistent
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])

    compile "com.android.support:appcompat-v7:${supportLibVersion}"
    compile "com.android.support:design:${supportLibVersion}"
}