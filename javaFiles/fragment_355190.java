subprojects {
    apply plugin: 'java'

    sourceCompatibility = 1.9

    compileJava {
        doFirst {
            options.compilerArgs += [
                    '--module-path', classpath.asPath
            ]
            classpath = files()
        }
    }
}