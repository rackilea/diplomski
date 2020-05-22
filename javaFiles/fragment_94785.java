File dir = new File(".");
FileFilter fileFilter = new WildcardFileFilter("*test*.java~*~");
File[] files = dir.listFiles(fileFilter);
for (int i = 0; i < files.length; i++) {
  System.out.println(files[i]);
}