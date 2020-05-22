android {
compileSdkVersion 23
buildToolsVersion "23.0.2"

defaultConfig {

    minSdkVersion 14
    targetSdkVersion 23
    versionCode 1
    versionName "1.0"

    // Enabling multidex support.
    multiDexEnabled true

}

 // add dexOptions
dexOptions {
    incremental true
    javaMaxHeapSize "4g"
}
}


dependencies {
provided fileTree(include: ['*.jar'], dir: 'libs')
testCompile 'junit:junit:4.12'
compile 'com.android.support:appcompat-v7:23.1.1'
compile 'com.android.support:support-v4:23.1.1'
compile 'com.android.support:design:23.1.1'
compile 'com.parse:parse-android:1.11.0'
 // add multidex dependency 
compile 'com.android.support:multidex:1.0.1'

}