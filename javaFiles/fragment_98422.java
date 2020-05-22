android {
...
    defaultPublishConfig groupFreePro + groupDebugRelease.capitalize()

    productFlavors {
        free
        pro
    }

    ...
    sourceSets {
        main {
            java.srcDirs = ['/src']
            res.srcDirs = ['/res']
        }

        free {
            java.srcDirs = ["free/src"]
            res.srcDirs = ["free/res"]
        }

        pro {
            java.srcDirs = ["pro/src"]
            res.srcDirs = ["pro/res"]
        }
    }
    ...
}

dependencies {
    freeCompile fileTree(dir: 'free/lib', include: '*.jar')
}