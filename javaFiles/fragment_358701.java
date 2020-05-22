buildscript {
  repositories {
    ...
    mavenCentral()
  }
  dependencies {
    ...
    classpath "com.android.tools.build:gradle:2.2.3"
     classpath 'me.tatarka:gradle-retrolambda:3.5.0'
  }
}

//At the end of the file place this:
apply plugin: 'me.tatarka.retrolambda'