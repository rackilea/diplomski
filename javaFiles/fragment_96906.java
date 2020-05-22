sourceSets {
  ...
  compileTwo {
    java {
      srcDirs = ['abc2']
    }
  }
}
...
task compileTwo(type: JavaCompile) {
  source = sourceSets.compileTwo.allSource.srcDirs
  destinationDir = file('classes')    
  classpath = configurations.compile  
}