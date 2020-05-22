jar {
    from files('path/to/file.class', 'path/to/otherfile.class'
    // or
    from fileTree('path/to/dir') {
        include '**/*.class'
    }
}