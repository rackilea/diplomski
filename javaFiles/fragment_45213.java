configurations.all {
  resolutionStrategy {
    // For a version that doesn't package javax.ws
    force 'com.sun.jersey:jersey-core:1.19' 
  }
}