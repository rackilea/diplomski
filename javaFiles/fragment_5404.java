task integTestReport (type: JacocoReport) {

    executionData project.tasks.integTest

    sourceDirectories = project.files(project.sourceSets.test.allSource.srcDirs)
    classDirectories = project.sourceSets.test.output

    def reportDir = project.reporting.file("jacoco/integTest/html")
    reports {
        html.destination = reportDir
    }
    doLast {
        println "See report at: file://${reportDir.toURI().path}index.html"
    }
}