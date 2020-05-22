configurations {
    // a dedicated Configuration for Groovy classpath
    groovyScript
}

dependencies {
    // Set Groovy dependency so groovy.ui.GroovyMain can be found.
    groovyScript localGroovy()
}

task generateClass(type: JavaExec) {

    // Set class path used for running Groovy command line.
    classpath = configurations.groovyScript

    // Main class that runs the Groovy command line.
    main = 'groovy.ui.GroovyMain'

    // Pass your groovy script as argument of the GroovyMain main
    // (can be improved)
    args 'src/main/groovy/generatorScript.groovy'

}