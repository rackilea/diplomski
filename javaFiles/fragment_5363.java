jar {
    baseName '<jar_name>'
    manifest {
        attributes 'Main-Class': 'blog.BlogAppKt'
    }

    from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
}