apply plugin: 'jacoco'

task jacocoReport(type: JacocoReport) {
    reports {
        xml {
            enabled true // coveralls plugin depends on xml format report
        }

        html {
            enabled true
        }
    }

    afterEvaluate {
        classDirectories = files(classDirectories.files.collect {
            fileTree(dir: it,
                    exclude: ['codeeval/**',
                              'crackingthecode/part3knowledgebased/**',
                              '**/Chapter7ObjectOrientedDesign**',
                              '**/Chapter11Testing**',
                              '**/Chapter12SystemDesignAndMemoryLimits**',
                              'projecteuler/**'])
        })
    }
}