List<Path> filteredFiles = new ArrayList<>();

SimpleFileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (Files.isRegularFile(file) && file.getFileName()
                                             .toString()
                                             .contains("key1")) {
            filteredFiles.add(file);
        }

        if (filteredFiles.size() == 50) {
            return FileVisitResult.TERMINATE;
        }
        return super.visitFile(file, attrs);
    }
};