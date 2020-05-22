jar {
    manifest {
        // take the existing file as a basis for the generated manifest:
        from 'MANIFEST.MF'
        // add an attribute to the generated manifest file:
        attributes 'Main-Class': application.mainClassName
    }
}