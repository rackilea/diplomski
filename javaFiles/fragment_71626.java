task serviceTest(type: Test) {
    // Runs tests from src/serviceTest
    testClassesDirs = sourceSets.serviceTest.output.classesDirs
    classpath = sourceSets.serviceTest.runtimeClasspath
}
// Setup serviceTest task 
serviceTest {
    // Uncomment this if you need to skip tests from the set after first failure. Since Gradle 4.6
    //failFast = true

    // Enable some logging
    testLogging {
        events "PASSED", "FAILED", "SKIPPED"
    }

    // Enable JUnit5 tests
    useJUnitPlatform {
    }
}