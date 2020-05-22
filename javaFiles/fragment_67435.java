sourceSets {
    ...

    test {
        java {
            srcDirs = ["test/model"]  // Note @Peter's comment below
        }
    }
}