// note the `JavaExec` task is only available from the java plugin,
// this may or may not what your app needs
// reference: https://docs.gradle.org/current/javadoc/org/gradle/api/tasks/JavaExec.html
apply plugin: 'java'

task runFromGradle(type: JavaExec) {
  // here gradle has access to the raw sourcesets
  // so we can directly use them for the runtime
  classpath = sourceSets.main.runtimeClasspath

  main = 'com.me.Main'

  // arguments to pass to the application
  args 'path/to/some.csv'
}

# from command line
$ gradle runFromGradle

# java class is the same