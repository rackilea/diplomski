task fatJar(type: Jar) {
   baseName = project.name + '-all'
   manifest {
        attributes 'Implementation-Title': 'Gradle Jar File Example',
            'Implementation-Version': version,
            'Main-Class': 'com.mkyong.DateUtils'
    }
   from { configurations.compile.collect { it.isDirectory() ? it : 
    zipTree(it) } 
    }
   with jar
}