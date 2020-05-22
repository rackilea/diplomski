apply plugin: 'java'

sourceSets {
  main {
    resources {
      srcDir 'props'
    }
  }
}

// this is to force Gradle to create the JAR used at 
// runtime with the correct folder structure
jar.into('props')

idea.module.iml.withXml {
  def node = it.asNode()
  // this is to force IntelliJ to create the folders 
  // used at runtime with the correct folder ('package') structure
  node.component.content.sourceFolder.@packagePrefix="props"
}