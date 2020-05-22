apply plugin: 'java'

sourceSets {
  main {
    java {
      srcDir 'src'
      exclude '**/*Tests.java'
    }
  }

  test {
    java {
      srcDir 'src'
      include '**/*Tests.java'
    }
  }
}