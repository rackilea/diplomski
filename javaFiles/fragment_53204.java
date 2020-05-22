apply plugin: 'com.android.application'
android {
  dexOptions {
      //incremental true
      javaMaxHeapSize "2048M"
  }

  compileSdkVersion 23
  buildToolsVersion '23.0.2'
  defaultConfig {
    applicationId "com.agte.agtevivo"
    minSdkVersion 14
    targetSdkVersion 23
    versionCode 1
    versionName "1.0"

    multiDexEnabled true
}