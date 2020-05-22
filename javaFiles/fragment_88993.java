j2objcConfig {
    ...
    testPattern {
        // Only run Java unit tests that end with "Test.java"
        include '**/*Test.java'

        // Exclude a single test without needing to specify the full path
        exclude '**/LogTest.java'

        // Exclude all tests within "ignoreDirectory"
        exclude 'ignoreDirectory/**'
    }
    ...
}