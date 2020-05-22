configurations.all {  
  resolutionStrategy {
    dependencySubstitution {
      substitute module('commons-io:commons-io:2.4') with project(':my-commons-io')
    }
  }
}