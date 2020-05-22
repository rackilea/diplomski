//project.tasks.withType(Test).each { t ->
//    t.jacoco {
//        destinationFile = project.file("$project.buildDir/jacoco/test.exec")
//    }
//}

jacocoTestReport.executionData(test)
jacocoTestReport.executionData(integrationTest)