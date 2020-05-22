android {
 compileSdkVersion 24
    buildToolsVersion "24.0.3"
    defaultConfig {
        applicationId "com.example.informatica.xabiagame"
        minSdkVersion 15
        targetSdkVersion 24
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
        multiDexEnabled true

        jackOptions {
            enabled true
        }
// ...
aaptOptions.cruncherEnabled = false
aaptOptions.useNewCruncher = false
// ...
}