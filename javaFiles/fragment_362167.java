apply plugin: 'com.android.application'

android {
    compileSdkVersion 23
    buildToolsVersion ...
    ....


    dependencies {
        compile fileTree(include: ['*.jar'], dir: 'libs')
        compile 'com.android.support:appcompat-v7:23.1.1'
        ...

        compile 'com.mcxiaoke.volley:library:1.+'
    }