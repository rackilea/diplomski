task makeMyExec(type: Copy) {

  dependsOn('installDist','script1','script2','script3')
  from rootProject.file("projName/build/install/exec/")
  into rootProject.file("../myExec/")
}