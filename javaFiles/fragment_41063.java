while(notFinished) {
  String variableDirectoryName = getDirectoryName();
  File[] files = new File("D:/level1/level2/" + variableDirectoryName + "/level3/goal").listFiles();
  for(File file : files) {
      // do whatever with the file
  }
}