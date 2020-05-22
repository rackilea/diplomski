sourceSets {

    // override the main, telling gradle main has no sources.
    main {
        java { srcDirs = [] }
        resources { srcDirs = [] }
    }

    // debug builds
    debug {
        java {
            compileClasspath += main.output
            runtimeClasspath += main.output
            //  combine code from main and debug java code
            srcDirs = ['src/debug/java', 'src/main/java']
        }
        // combine resources
        resources {
            srcDirs = ['src/debug/resources', 'src/main/resources']
        }
        // override the resources and classes output, for compatibility with the war plugin
        output.resourcesDir = 'build/resources/main'
        output.classesDir = 'build/classes/java/main'
    }

    // release builds
    release {
        java {
            compileClasspath += main.output
            runtimeClasspath += main.output
            //  combine code from main and release java code
            srcDirs = ['src/release/java', 'src/main/java']
        }
        // combine resources
        resources {
            srcDirs = ['src/release/resources', 'src/main/resources']
        }
        // override the resources and classes output, for compatibility with the war plugin
        output.resourcesDir = 'build/resources/main'
        output.classesDir = 'build/classes/java/main'
    }
}

task debugWar(type: War, group: 'Build') {
    classifier 'SNAPSHOT'
    from sourceSets.debug.output
    // add the debug dependencies
    classpath configurations.debug    
}

task releaseWar(type: War, group: 'Build') {
    from sourceSets.release.output    
}