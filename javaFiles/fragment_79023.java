apply plugin: 'java'

sourceCompatibility = JavaVersion.VERSION_1_7
targetCompatibility = JavaVersion.VERSION_1_7

repositories {
    mavenCentral()
}

dependencies {
    compile 'com.j256.ormlite:ormlite-core:4.48'
    compile 'com.j256.ormlite:ormlite-android:4.48'
    compile 'com.j256.ormlite:ormlite-jdbc:4.48'
}