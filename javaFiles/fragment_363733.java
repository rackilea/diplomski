apply plugin: "maven-publish"

publishing {
  publications {
    maven(MavenPublication) {
      artifact 'my-file-name.jar' // Publish a file created outside of the build
    }
  }
}