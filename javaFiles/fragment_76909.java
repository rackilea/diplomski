task testJUnitJupiter(type: Test) {
    description = "Runs JUnit Jupiter tests."
    useJUnitPlatform {
        includeEngines "junit-jupiter"
        excludeTags "failing-test-case"
    }
    filter {
        includeTestsMatching "org.springframework.test.context.junit.jupiter.*"
    }
    reports.junitXml.destination = file("$buildDir/test-results")
    // Java Util Logging for the JUnit Platform.
    // systemProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager")
}

test {
    description = "Runs JUnit 4 tests."
    dependsOn testJUnitJupiter, testNG
    useJUnit()
    scanForTestClasses = false
    include(["**/*Tests.class", "**/*Test.class"])
    exclude(["**/testng/**/*.*", "**/jupiter/**/*.*"])
    reports.junitXml.destination = file("$buildDir/test-results")
}