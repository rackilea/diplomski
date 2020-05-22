// $rootDir/dependencies.gradle.kts

// this will try to take configuration from existing ones
val compile by configurations
val api by configurations
dependencies {
  compile("commons-io:commons-io:1.2.3")
  api("some.dep")
}

// This will put your version into extra extension
extra["springBootVersion"] = "1.2.3"