private static void doSomethingToDirectory(File factDir) throws IOException {
  if (factDir.isDirectory()) {
    for (File file : factDir.listFiles()) {
      if (file.isDirectory()) {
        for (File child : file.listFiles(new MyFilter())) {
          process(child);
        }
      }
    }           
  }
}

class MyFilter implements FilenameFilter {
  public boolean accept(File dir, String name) {
    return name.equals(TEMP_COMPARE_FILE);
  }
}