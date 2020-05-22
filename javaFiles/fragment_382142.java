task fatJar(type: Jar) {
    manifest {
        attributes 'Main-Class': 'com.example.Main'
    }
    baseName = project.name + '-all'
    from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
    with jar
}