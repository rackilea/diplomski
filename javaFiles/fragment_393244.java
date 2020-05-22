buildscript {
    repositories {
        mavenCentral()
        google()
        jcenter()
    }

    dependencies {
        classpath 'com.android.tools.build:gradle:3.3.0'
        //implementation 'com.google.firebase:firebase-core:17.0.0'  --> remove this
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: '*.jar')
    // SUB-PROJECT DEPENDENCIES START
    implementation(project(path: ":CordovaLib"))
    implementation "com.android.support:support-v4:24.1.1+"
    implementation "com.android.support:support-annotations:27.+"
    implementation "com.onesignal:OneSignal:3.10.8"
    // SUB-PROJECT DEPENDENCIES END

    implementation 'com.google.firebase:firebase-core:17.0.0'  // <-- add in this block
}