jar {
  manifest {
    attributes(
      "Class-Path": configurations.compile.collect { it.getName() }.join(' '))
  }
}