buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "com.jtransc:jtransc-gradle-plugin:0.6.8"
  }
}

apply plugin: "com.jtransc"