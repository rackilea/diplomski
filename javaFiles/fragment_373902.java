sourceSets {
    main {
        compileClasspath += generated.output
        runtimeClasspath += generated.output
    }
}