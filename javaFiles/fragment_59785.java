task interfaceJar(type: Jar) {
    classifier = 'interface'

    from "$buildDir/classes/main/"
    from configurations.compile.findAll{it.name.contains('kryo')}

    include 'x/y/z/stuff.class'
    include '*.jar'
}