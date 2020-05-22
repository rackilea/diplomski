jar {
    manifest {
        attributes 'Main-Class': 'com.CAM.Starter'
    }
    from {
        configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }
    }
}