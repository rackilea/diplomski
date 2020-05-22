buildTypes {
    debug {
        runProguard false
    }

    release {
        runProguard true
        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-project.txt'
    }
}