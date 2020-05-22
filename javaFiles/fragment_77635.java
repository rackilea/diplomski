apply plugin: 'com.android.library'

android {
    compileSdkVersion 28

    publishNonDefault true

    defaultConfig {
        minSdkVersion 21
        targetSdkVersion 28
        versionCode 1
        versionName "1.0"
    }

    sourceSets {
        main {
            if (hasLottieSupport.toBoolean()) {
                java.srcDirs += 'lottieYes/java'

            } else {
                java.srcDirs += 'lottieNo/java'
                res.srcDirs += 'lottieNo/res'
            }
        }
    }

    buildTypes {
        debug {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }

        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation 'com.android.support:appcompat-v7:28.0.0'

    if (hasLottieSupport.toBoolean()) {
        implementation 'com.airbnb.android:lottie:2.5.6'
    }
}