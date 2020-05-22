task interfaceJar(type: Jar) {
    classifier = 'interface'
    from("$buildDir/classes/main/"){
        include 'stuff.class'
    }

    configurations.compile.findAll{it.name.contains('kryo')}.each{
        from(it.isDirectory() ? it : zipTree(it))
    }
}