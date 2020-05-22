File file = new File("/base/folder");
Files.walkFileTree(file.toPath(), new SimpleFileVisitor<>() {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        // do your thing here
        return FileVisitResult.CONTINUE;
    }
});