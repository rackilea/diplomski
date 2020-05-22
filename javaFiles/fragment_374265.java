subprojects() {
  dependencies {   
     if (file('compile.dependencies').exists()) {
       compile file('compile.dependencies').readLines()
     }

     if (file('runtime.dependencies').exists()) {
      runtime file('runtime.dependencies').readLines()
     }
  }
}