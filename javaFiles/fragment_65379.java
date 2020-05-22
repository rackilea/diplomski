List testClassNames() {
    File classesDir = sourceSets.test.output.classesDir
    String prefix = classesDir.toString() + '/'
    List names = []
    classesDir.traverse {
        if( it.absolutePath.endsWith( '.class' ) ) {
            String name = (it.absolutePath - prefix).replaceAll( '/', '.' ) - '.class'
            names << name
        }
    }
    return names
}

ClassLoader getClassLoader() {
    List urls = sourceSets.test.runtimeClasspath.collect {
        it.toURI().toURL()
    }
    return URLClassLoader.newInstance( urls as URL[] )
}

List annotationFilter( Map map ) {
    map.prefix = map?.prefix ?: '' // prefix: provide convenience for passing in annotation names

    ClassLoader loader = classLoader

    List result

    // filter with annotations
    if( !map.includes ) {
        result = map?.names
    } else {
        result = []
        map?.names.each { name ->
            Class klass = loader.loadClass( name )
            map?.includes.each { annotationName ->
                String fullName = map.prefix + annotationName
                Class<? extends Annotation> annotation = loader.loadClass( fullName ).asSubclass( Annotation )
                if( klass.isAnnotationPresent( annotation ) ) {
                    result << name
                }
            }
        }
    }

    if( result?.size() == 0 ) result = [ 'no.tests.to.run' ]
    return result
}

task smoke( type: Test, description: 'Run smoke tests' ) {
    doFirst {
        List names = testClassNames()
        List filtered = annotationFilter( names: names, includes: ['demo.Smoke'] )
        println 'Running ' + filtered.size() + ' tests:\n' + filtered*.toString()*.replaceAll('^','\t').join('\n')

        filter {
            setIncludePatterns( filtered as String[] )
        }
    }
}