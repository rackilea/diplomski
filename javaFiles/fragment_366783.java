apply plugin: 'java'

jar { 
    doLast {
        new File("${buildDir}/libs").eachFileRecurse { file ->
            println "TRACER: ${file.getAbsolutePath()}"
        }
    }
}