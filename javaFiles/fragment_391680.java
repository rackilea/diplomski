// $rootDir/build.gradle.kts
subprojects {
  apply {
    plugin<JavaLibraryPlugin>()
    from("$rootDir/dependencies.gradle.kts")
  }