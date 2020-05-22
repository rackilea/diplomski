// $rootDir/build.gradle.kts
subprojects {
  apply {
    plugin(KotlinPlatformJvmPlugin::class)
    from("common.gradle.kts")
  }
}