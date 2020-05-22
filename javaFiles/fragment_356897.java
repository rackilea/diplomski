sourceSets {
    integrationTest {
        java {
            srcDirs = ['src/integration']
        }
        groovy {
            srcDirs = ['src/integration']
        }
        resources.srcDir file('src/integration/resources')
    }

    test {
        java {
            srcDirs = ['src/test']
        }
        groovy {
            srcDirs = ['src/test']
        }
    }
}