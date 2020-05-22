jar {
    manifest {
        attributes 'Main-Class': 'de.testing.Launcher'
    }
    from {
        configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }
    }
}