// $rootDir/buildSrc/src/main/kotlin/common.gradle.kts
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.3.21"
}
tasks.compileKotlin {
  kotlinOptions.jvmTarget = "1.8"
}
tasks.compileTestKotlin {
  kotlinOptions.jvmTarget = "1.8"
}