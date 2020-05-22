buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:0.5.+'
    }
}

apply plugin: 'android'

repositories {
    mavenCentral()
}

dependencies {
    compile fileTree(dir: 'libs', include: '*.jar')
    compile 'com.github.chrisbanes.actionbarpulltorefresh:library:+'
}

android {
    compileSdkVersion 18
    buildToolsVersion '18'

    defaultConfig {
        targetSdkVersion 18
    }

    sourceSets {
        main {
            manifest.srcFile 'AndroidManifest.xml'
            java.srcDirs = ['src']
            res.srcDirs = ['res']
        }
    }
}