configurations {
    doc {
        transitive false
    }
}

dependencies {
    doc 'com.google.code.gson:gson:2.3.1:sources'
    doc 'commons-collections:commons-collections:3.2.1:sources'
}

javadoc {
    source configurations.doc.collect { zipTree(it) }
    include '**/*.java'
    options.addStringOption('Xdoclint:none', '-quiet')
}