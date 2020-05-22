public static void copyTree(Path from, Path to, CopyOption... options) throws IOException {
    from = from.toAbsolutePath();
    Path base = from.getParent();
    if(!Files.exists(to)) Files.createDirectories(to);

    Files.walkFileTree(from, new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                                                                       throws IOException {
            return copy(dir);
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                                                                       throws IOException {
            return copy(file);
        }

        private FileVisitResult copy(Path file) throws IOException {
            Files.copy(file, to.resolve(base.relativize(file)), options);
            return FileVisitResult.CONTINUE;
        }
    });
}