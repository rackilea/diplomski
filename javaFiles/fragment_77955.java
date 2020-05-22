apply plugin: 'com.android.application'
android {
    configurations.all {
        resolutionStrategy.force 'com.google.code.findbugs:jsr305:1.3.9'
    }
    compileSdkVersion 28
    buildToolsVersion "28.0.3"strong text
    defaultConfig {
        minSdkVersion 16
        targetSdkVersion 28
        manifestPlaceholders = [appPackageName: "${applicationId}"]
        multiDexEnabled true
    }
    dexOptions {
        jumboMode true
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }

    flavorDimensions "version"

    productFlavors {
        pixol {
            dimension "version"
            applicationId "com.dslr.camera.pixol"

            //Package name change it before uploading to store
            resValue "string", "app_name", "Pixol" //app name change it before uploading to store
            resValue "string", "dev_name", "" // Google play developer name
            resValue "string", "facebook_app_id", "" //facebook app id (get it from facebook sdk see the dcumentation)
            //admob
            resValue "string", "main_full", "YOUR_ADMOB_AD_UNIT_HERE"// admob interstitial ad 1
            resValue "string", "result_full", "YOUR_ADMOB_AD_UNIT_HERE" // admob interstitial ad 2
            resValue "string", "main_native", "YOUR_ADMOB_AD_UNIT_HERE" // admob naive large tamplate
            resValue "string", "result_native", "YOUR_ADMOB_AD_UNIT_HERE" // admob naive large tamplate

            //audience network
            resValue "string", "main_full_fb", "YOUR_FACEBOOK_AD_UNIT_HERE"// fb ad interstitial ad 1
            resValue "string", "result_full_fb", "YOUR_FACEBOOK_AD_UNIT_HERE"// fb ad interstitial ad 2


            manifestPlaceholders = [appIcon: "@mipmap/ic_launcher"] // app icon change in mipmap folder
            versionCode 2
            versionName "1"

        }

    }

    /* 3) Exclude duplicate licenses */
    packagingOptions {
        exclude 'META-INF/LICENSE.txt'
        exclude 'META-INF/LICENSE'
        exclude 'META-INF/NOTICE.txt'
        exclude 'META-INF/NOTICE'
        exclude 'META-INF/DEPENDENCIES'
        pickFirst 'AndroidManifest.xml'
        exclude 'META-INF/rxjava.properties'
    }


}

dependencies {
  /*  compile fileTree(include: ['*.jar'], dir: 'libs')
    *//* 4) Add the CSDK framework dependencies (Make sure these version numbers are correct) *//*
    compile 'com.android.support:appcompat-v7:25.3.1'
    compile 'com.mlsdev.rximagepicker:library:2.0.0'
    compile 'com.adobe.creativesdk.foundation:auth:0.9.1251'
    compile 'com.adobe.creativesdk:image:4.8.4'
    compile 'com.localytics.android:library:3.8.0'
    compile 'com.github.medyo:fancybuttons:1.8.3'
    compile 'com.jakewharton:butterknife:7.0.1'
    compile 'com.android.support:multidex:1.0.0'
    compile 'com.facebook.android:facebook-android-sdk:[4,5)'
    compile 'com.facebook.android:audience-network-sdk:4.+'

    compile 'com.google.android.gms:play-services-ads:10.2.1'
    compile 'com.cocosw:bottomsheet:1.+@aar'*/

}