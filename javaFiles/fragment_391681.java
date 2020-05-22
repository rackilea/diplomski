// $rootDir/module/build.gradle.kts
// This will take existing dependency from extra
val springBootVersion: String by extra
dependencies {
  compile("org.spring:boot:$springBootVersion")
}