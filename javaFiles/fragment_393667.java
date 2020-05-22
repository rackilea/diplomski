apply plugin: 'com.android.application'


android {
compileSdkVersion 25
buildToolsVersion "26.0.1"

defaultConfig {
    applicationId "com.georgeberdovskiy.findmyphone"
    minSdkVersion 25
    targetSdkVersion 25
    versionCode 1
    versionName "1.0"
}
buildTypes {
    release {
        minifyEnabled false
        proguardFiles getDefaultProguardFile('proguard-android.txt'),       'proguard-rules.pro'
    }
    }
}

dependencies {
compile fileTree(dir: 'libs', include: ['*.jar'])
compile 'com.google.android.support:wearable:2.0.3'
provided 'com.google.android.wearable:wearable:2.0.3'
compile 'com.google.android.gms:play-services-maps:11.0.4'
compile 'com.google.firebase:firebase-core:11.0.4'
compile 'com.google.firebase:firebase-database:11.0.4'
compile 'com.google.android.gms:play-services-wearable:11.0.4'

}

apply plugin: 'com.google.gms.google-services'