final Collection<T> finalMutatedFileStorage = mutatedFileStorage;
final Application finalApplication = application; // guessing at the type here
Files.walkFileTree(Paths.get(modifiedPathName), new SimpleFileVisitor<Path>() {
  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
  throws IOException {
    if (attrs.isRegularFile()) {
       finalMutatedFileStorage.add((T) finalApplication.readFromFile(file));
    }
    return FileVisitResult.CONTINUE;
  }
});