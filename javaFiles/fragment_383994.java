repositories {
    mavenCentral()

    maven {
        url "https://raw.github.com/embarkmobile/zxing-android-minimal/mvn-repo/maven-repository/"
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile 'com.android.support:appcompat-v7:21.0.3'

    // Zxing libraries
    compile 'com.embarkmobile:zxing-android-minimal:2.0.0@aar'
    compile 'com.embarkmobile:zxing-android-integration:2.0.0@aar'
    compile 'com.google.zxing:core:3.0.1'

}