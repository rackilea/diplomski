Path p = Paths.get("C://");
FileVisitor<Path> fv = new SimpleFileVisitor<Path>() {
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
      throws IOException {
    System.out.println(file);
    return FileVisitResult.CONTINUE;
  }
};

try {
  Files.walkFileTree(p, fv);
} catch (IOException e) {
  e.printStackTrace();
}