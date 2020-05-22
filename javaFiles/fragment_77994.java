afterEvaluate {
    artifact project.sourcesJar {
        classifier "sources"
    }
    artifact project.testJar {
        classifier "tests"
    }
}