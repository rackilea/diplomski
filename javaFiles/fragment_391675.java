// $rootDir/buildSrc/build.gradle.kts
plugins {
  `kotlin-dsl`
}
repositories {
   maven {
     url = uri("http://host:8082/artifactory/...")
  }
}