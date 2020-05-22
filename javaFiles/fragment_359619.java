FilenameFilter javaFileFilter= new FilenameFilter() {  
  @Override
  public boolean accept(File logDir, String name) {
    return name.endsWith(".java")
  }
};