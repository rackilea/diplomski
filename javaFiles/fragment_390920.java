apply plugin: 'war'

sourceSets {
    main {
        output.resourcesDir = 'build/resources'
        output.classesDir   = 'build/classes'
    }
    debug {
        java {
            compileClasspath += main.output
            runtimeClasspath += main.output
        }
        output.resourcesDir = 'build/resources'
        output.classesDir   = 'build/classes'
    }
}

task assembleDebugWar(type: War) {
    from sourceSets.debug.output
    archiveName "ROOT.war"
}

task assembleReleaseWar(type: War) {
    from sourceSets.main.output
    archiveName "ROOT.war"
}