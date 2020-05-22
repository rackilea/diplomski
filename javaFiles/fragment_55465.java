apply plugin: 'com.android.application'

apply plugin: 'kotlin-android'

apply plugin: 'kotlin-android-extensions'

apply plugin: 'io.fabric'

android {
    compileSdkVersion 28
    buildToolsVersion "28.0.3"

    defaultConfig {
        versionName "2.2.4"
        versionCode 13

        minSdkVersion 16
        targetSdkVersion 27

        multiDexEnabled true

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        debug {
            applicationIdSuffix ".debug"
            versionNameSuffix ".d.5"
        }

        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }

    flavorDimensions "server"

    productFlavors {
        prod {
            applicationId "com.tfwm.lighting"
            dimension "server"

            buildConfigField "String", "SERVER_HOST", "\"http://www.test.com\""
        }

        dev {
            applicationId "dev.tfwm.lighting"
            versionNameSuffix ".dev"
            dimension "server"

            buildConfigField "String", "SERVER_HOST", "\"http://localhost/test\""
        }
    }
}

dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    androidTestImplementation('androidx.test.espresso:espresso-core:3.1.0-alpha4', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    implementation('com.crashlytics.sdk.android:crashlytics:2.7.1@aar') {
        transitive = true
    }

    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation 'com.schibstedspain.android:leku:6.0.0'

    implementation 'com.github.sparklit:adbutler-android-sdk:1.0'
    implementation 'com.j256.ormlite:ormlite-core:5.0'
    implementation 'com.j256.ormlite:ormlite-android:5.0'
    implementation 'com.squareup.okhttp:okhttp:2.4.0'
    implementation 'androidx.appcompat:appcompat:1.0.0-beta01'
    implementation 'androidx.cardview:cardview:1.0.0-beta01'
    implementation 'androidx.recyclerview:recyclerview:1.0.0-beta01'
    implementation 'com.google.android.material:material:1.0.0-beta01'
    implementation 'androidx.vectordrawable:vectordrawable:1.0.0-beta01'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.2'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0-beta01'
    implementation 'com.google.android.gms:play-services-location:16.0.0'
    implementation 'com.google.firebase:firebase-core:16.0.7'
    implementation 'com.facebook.fresco:fresco:1.9.0'
    implementation 'com.jakewharton.timber:timber:4.7.0'
    implementation 'com.google.android.gms:play-services-maps:16.1.0'
    testImplementation 'junit:junit:4.12'
    def nav_version = "1.0.0-alpha09"
    implementation "android.arch.navigation:navigation-fragment:$nav_version"
    // use -ktx for Kotlin
    implementation "android.arch.navigation:navigation-ui:$nav_version"
    // use -ktx for Kotlin

    implementation 'pub.devrel:easypermissions:1.1.1'
    implementation 'devlight.io:navigationtabbar:1.2.5'
}

configurations.all {
    // this is a workaround for the issue:
    // https://stackoverflow.com/questions/52521302/how-to-solve-program-type-already-present-com-google-common-util-concurrent-lis
    exclude group: 'com.google.guava', module: 'listenablefuture'
}

apply plugin: 'com.google.gms.google-services'

repositories {
    mavenCentral()
}