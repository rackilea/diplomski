// $rootDir/buildSrc/settings.gradle.kts
pluginManagement {
  repositories.maven {
    url = uri("http://host:8082/artifactory/...")
  }
}