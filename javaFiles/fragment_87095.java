sourceSets {
    main {
        manifest.srcFile 'AndroidManifest.xml'
        java.srcDirs = ['src/main/java']
        resources.srcDirs = ['src/main/java']
        aidl.srcDirs = ['src/main/java']
        renderscript.srcDirs = ['src/main/java']
        res.srcDirs = ['res']
        assets.srcDirs = ['assets']
    }

    androidTest.java.srcDir 'src/androidTest/java'
    debug.setRoot('build-types/debug')
    release.setRoot('build-types/release')
}