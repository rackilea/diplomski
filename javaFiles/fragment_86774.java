eclipse.classpath.file {
  whenMerged { classpath ->
    def lib = new org.gradle.plugins.ide.eclipse.model.Library(fileReference(file('path/to/my/jar')))
    lib.exported = true
    classpath.entries << lib
  }
}