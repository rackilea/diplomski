ext {
    check = project.properties['check'] ?: "false"
}

task test {
    onlyIf { project.ext.check == "true" }
    doLast {
        println "TEST"
    }
}

task testSlowly {
    doFirst{ project.ext.check = "true" }
    finalizedBy 'test'
}