public Set<Path> getAllFiles(final String folder) throws IOException {
    return Files.walk(Paths.get(folder))
            .map(Path::toAbsolutePath)
            .flatMap(this::getAllFiles)
            .collect(Collectors.toSet());
}

private Stream<Path> getAllFiles(final Path path) {
    if(!Files.isSymbolicLink(path)) return Stream.of(path);
    try {
        return Files.walk(path, FileVisitOption.FOLLOW_LINKS)
                .filter(Files::isRegularFile);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return Stream.empty();
}