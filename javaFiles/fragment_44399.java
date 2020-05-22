if (project.gradle.startParameter?.taskRequests?.args[0]?.remove("--robolectric")) {
    subprojects
            .all {
        it.tasks
                .withType(Test)
                .configureEach {
            println "Configuring task $it.name"
            useJUnit {
                includeCategories 'my.package.WhateverClass'
            }
        }
    }
} else if (project.gradle.startParameter?.taskRequests?.args[0]?.remove("--unit")) {
    subprojects
            .all {
        it.tasks
                .withType(Test)
                .configureEach {
            println "Configuring task $it.name"
            useJUnit {
                excludeCategories 'my.package.WhateverClass'
            }
        }
    }
}