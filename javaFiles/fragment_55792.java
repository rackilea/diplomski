public Map<Path, Long> fileSizes(Path dir, String mask, boolean recursive) throws IOException {
    PathMatcher pathMatcher = dir.getFileSystem().getPathMatcher("glob:" + mask);
    return Files.walk(dir, recursive ? Integer.MAX_VALUE : 1)
            .filter(Files::isRegularFile)
            .filter(path -> pathMatcher.matches(path.getFileName()))
            .collect(Collectors.toMap(
                    Path::getFileName,
                    path -> {
                        try {
                            return Files.size(path);
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    }
            ));
}