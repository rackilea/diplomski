try (Stream<Path> tree =
    Files.walk(Paths.get("/home/talha")).filter(Files::isReadable)) {

    Iterator<Path> i = tree.iterator();
    while (i.hasNext()) {
        Path file = i.next();
        try (Stream<String> lines = Files.lines(file, charset)) {
            count += lines.filter(pattern.asPredicate()).count();
        }
    };
}