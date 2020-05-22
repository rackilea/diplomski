apply plugin: 'java'

jar {
   def included = project.file('classes.txt').readLines()
   include { f ->
      included.any { i -> f.isDirectory() ? true : f.path.replaceAll(File.separator, '.').contains(i) }
   }
}