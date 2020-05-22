sourceSets {
  java6Src // new source set
  main { // make sure our new source set is included as part of the main so it compiles and runs
    compileClasspath += java6src.output
    runtimeClasspath += java6Src.output
  }
}

compileJava6SrcJava { // set the compile options
  sourceCompatibility = 1.6
  targetCompatibility = 1.6
  // if jdk6.home is defined use it for compatibility
  def jdk6Home = System.properties['jdk6.home']
  if(jdk6Home) {
    options.bootClasspath = (new File(jdk6Home,"/jre/lib/rt.jar")).canonicalPath
  }
}


jar { // include java6Src set in the jar 
  from {
    sourceSets.java6Src.output
  }
}