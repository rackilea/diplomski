sourceSets {
    integrationTest {
        groovy {
            srcDirs = [file('integration-test/src/test/groovy')] as Set
        }
        resources {
            srcDirs = [file('integration-test/src/test/resources')] as Set
        }
    }
}