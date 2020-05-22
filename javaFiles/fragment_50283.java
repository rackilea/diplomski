sourceSets {
    main
    demo {
      compileClasspath += main.output
      runtimeClasspath += main.output
    }
}