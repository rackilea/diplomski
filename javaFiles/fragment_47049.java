jar {
  manifest {
    attributes("Main-Class": "org.hipi.examples.HelloWorld")
  }

  dependencies{
    compile project(':core')
  }

 from {
    configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }
}
}