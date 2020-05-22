jar {
     manifest {
        attributes 'Main-Class': 'api.KotlinSpringJpaPostgresqlApplicationKt'
    }
    from { 
        configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } 
    }
}