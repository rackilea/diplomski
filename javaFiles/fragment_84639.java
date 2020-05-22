sourceSets {
    main {
        java {
            srcDirs = ['src/main/java']
        }
    }
    test {
        groovy {
            srcDirs = ['src/test/ft/groovy', 'src/test/ut/groovy', 'src/test/ft/java' ]
        }
    }
}