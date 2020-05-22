configurations.all {
  resolutionStrategy {

    // force certain versions of dependencies (including transitive)
    //  *append new forced modules:
    force 'asm:asm-all:3.3.1', 'commons-io:commons-io:1.4'
  }
}