public static String match(String glob, String location) throws IOException {
    StringBuilder result = new StringBuilder();
    PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(glob);
    Files.walkFileTree(Paths.get(location), new SimpleFileVisitor<Path>() {

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
            if (pathMatcher.matches(path)) {
                result.append(path.toString());
                return FileVisitResult.TERMINATE;
            }
            return FileVisitResult.CONTINUE;
        }
    });

    return result.toString();
}