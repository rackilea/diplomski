Path dir = Paths.get("/dir");

Stream<Path> brokenLinks =
    Files.find(dir, 1, (path, attr) -> attr.isSymbolicLink())
    .filter(path -> {
        try {
            return !Files.exists(Files.readSymbolicLink(path));
        } catch (IOException e) {
            System.err.println("Couldn't read link " + path + ": " + e);
            return false;
        }
    });
long brokenLinkCount = brokenLinks.count();