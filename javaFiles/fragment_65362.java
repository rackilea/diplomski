task delombok(type: DelombokTask, dependsOn: compileJava) {
    ext.outputDir = file("$buildDir/delombok")
    outputs.dir(outputDir)
    sourceSets.main.java.srcDirs.each { 
        inputs.dir(it)
        args(it, "-d", outputDir)
    }
}

javadoc {
    dependsOn delombok
    source = delombok.outputDir
    failOnError = false
}