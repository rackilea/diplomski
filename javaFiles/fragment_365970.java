task runApp(type: JavaExec) {
  classpath = sourceSets.main.runtimeClasspath
  main = 'package.Main' //class to run

  // add debug arguments as required, for example:
  args '-Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8888,suspend=n'
}