bootRun {
    if ( project.hasProperty('jvmArgs') ) {
        jvmArgs project.jvmArgs.split('\\s+')
    }
}

gradle bootRun -PjvmArgs="-Dwhatever1=value1 -Dwhatever2=value2"