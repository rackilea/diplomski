jacocoTestReport {
    additionalSourceDirs = files(sourceSets.main.allSource.srcDirs)
    classDirectories =  files(sourceSets.main.output)
    sourceDirectories = files(sourceSets.main.allSource.srcDirs)

    afterEvaluate {
        classDirectories = files(classDirectories.files.collect {
            fileTree(dir: it, exclude: 'path/to/test/*Test.java')
        })
    }

    reports {
        html.enabled = true
        xml.enabled = true
        csv.enabled = false
    }
}