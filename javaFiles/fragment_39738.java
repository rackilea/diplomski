...
android {
...
defaultConfig { ... }
signingConfigs {
    release {
        storeFile file("myreleasekey.keystore")
        storePassword "password"
        keyAlias "MyReleaseKey"
        keyPassword "password"
    }
}
buildTypes {
    release {
        ...
        signingConfig signingConfigs.release
    }
}
}
...