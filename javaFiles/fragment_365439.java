buildscript {
  repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
  }
  dependencies {
    // experimental gradle plugin for the library to compile native code with NDK
    classpath "com.android.tools.build:gradle-experimental:0.7.2"

    // regular gradle plugin for the tests
    classpath 'com.android.tools.build:gradle:2.1.2'
  }
}

subprojects {
  task listAllDependencies(type: DependencyReportTask) {}
}