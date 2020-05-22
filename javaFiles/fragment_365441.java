apply plugin: 'com.android.application'

allprojects {
  repositories {
    mavenLocal()
    mavenCentral()
  }
}

repositories {
  mavenLocal()
  mavenCentral()
}

android {
  compileSdkVersion 16
  buildToolsVersion "22.0.1"

  defaultConfig {
    applicationId "app.tests"
    minSdkVersion 9
    targetSdkVersion 16
    versionCode 359
    versionName "1.3"

    testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
  }

  sourceSets {
    main {
      manifest.srcFile 'AndroidManifest.xml'
    }

    androidTest {
      manifest.srcFile 'AndroidManifest.xml'
      java.srcDirs = ['src']

      jni {
        dependencies {
          project ":library"
        }
      }
    }
  }
}

dependencies {
  androidTestCompile project(':library')
  androidTestCompile fileTree(include: ['*.jar'], dir: 'libs')
}