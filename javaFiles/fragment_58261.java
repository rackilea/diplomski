configurations {
    provided
}

sourceSets {
    main {
    compileClasspath += configurations.provided
    compileClasspath += configurations.compile
    compileClasspath += configurations.runtime
    java {
        srcDir 'src/main/application'
    }
    }
}