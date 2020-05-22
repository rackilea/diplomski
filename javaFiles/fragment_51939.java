android {
    compileSdkVersion //
    buildToolsVersion //

    defaultConfig {
        ...
        minSdkVersion 14
        targetSdkVersion //
        ...

        // Enabling multidex support.
        multiDexEnabled true
    }
    ...
}

dependencies {
  compile 'com.android.support:multidex:1.0.1' 
}