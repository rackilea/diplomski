allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
dependencies {
    compile 'com.github.yeriomin:play-store-api:0.19'
    compile 'com.squareup.okhttp3:okhttp:3.8.1'
}