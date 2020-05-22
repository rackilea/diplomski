bootRun {
    if ( project.hasProperty('jvmArgs') ) {
        jvmArgs = (project.jvmArgs.split("\\s+") as List)

    }
}