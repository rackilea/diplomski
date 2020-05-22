File source = new File("C:/Users/java/dir1");
File dest = new File("C:/Users/java/dir2");
try {
    FileUtils.copyDirectory(source, dest);
} catch (IOException e) {
    e.printStackTrace();
}