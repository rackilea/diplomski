jar {
    from {
        configurations.compile.collect {
            it.isDirectory() ? it : zipTree(it)
        }
    }
    manifest {
        attributes 'Main-Class': 'Test'
    }
}