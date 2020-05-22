jar {
    manifest {
        attributes 'Main-Class': 'com.CAM.Starter'
    }
    from {
        configurations.runtimeClasspath.collect { it.isDirectory() ? it : zipTree(it) }
    }
}