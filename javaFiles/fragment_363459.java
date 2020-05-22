repositories {
    mavenCentral()
}

dependencies {
    compile 'com.android.support:appcompat-v7:22.0.0' // <-- updated
}

android {
    compileSdkVersion 22
    buildToolsVersion "22.0.1"

    sourceSets {
        main {
            manifest.srcFile 'AndroidManifest.xml'
            java.srcDirs = ['src']
            resources.srcDirs = ['src']
            aidl.srcDirs = ['src']
            renderscript.srcDirs = ['src']
            res.srcDirs = ['res']
            assets.srcDirs = ['assets']
        }

        androidTest.setRoot('tests')
    }
}