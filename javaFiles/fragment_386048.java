apply plugin: "io.freefair.aspectj.post-compile-weaving"

dependencies {
    compileOnly "org.aspectj:aspectjrt:1.9.4"
    compileOnly project(':app.common')
    compileOnly project(':app.program.main')

    compileOnly org_apache_logging_log4j__log4j_api

    inpath(project(":app.program.main")) {
        transitive = false
    }
}

compileJava.ajc.options.compilerArgs += "-showWeaveInfo"
compileJava.ajc.options.compilerArgs += "-verbose"