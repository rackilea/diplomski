android {

    compileSdkVersion 25
    buildToolsVersion '25.0.2'

    aaptOptions.cruncherEnabled = false
    aaptOptions.useNewCruncher = false

    defaultConfig {
        applicationId "xxx.xxxx.xxxx.xxxx"
        minSdkVersion 9
        targetSdkVersion 25
        useLibrary  'org.apache.http.legacy'
        compileOptions {
            sourceCompatibility JavaVersion.VERSION_1_5
            targetCompatibility JavaVersion.VERSION_1_5
        }
        //remaining code snippet
        //.....
    }
    //remaining code snippet
    //.....
}