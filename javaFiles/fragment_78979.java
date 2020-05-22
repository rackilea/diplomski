repositories {
    flatDir {
        dirs 'libs'
    }
}

dependencies {    
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile(name:'kinvey-android-*', ext:'aar')

    // other stuff
}