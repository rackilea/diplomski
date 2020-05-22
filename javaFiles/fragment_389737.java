task mergeCopy(type: MergeCopy) {
    configurations.compile.files.each {
        from it.directory ? fileTree(it) : zipTree(it)
    } 
    into "$buildDir/mergeCopy"
    merger = { String path, List<File> files, OutputStream out ->
       // TODO: implement
    }
}

task fatJar(type: Jar) {
    dependsOn mergeCopy
    from mergeCopy.outputDir
    ...
}