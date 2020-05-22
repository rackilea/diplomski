buildscript {
    repositories {
        mavenCentral()
        mavenLocal()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:0.5.+'
    }
}
apply plugin: 'android'

dependencies {

    repositories {
        mavenCentral()
    }

    compile fileTree(dir: 'libs', include: '*.jar')
    compile 'com.android.support:support-v4:18.0.0'
    compile 'com.android.support:appcompat-v7:18.0.+'
....
}