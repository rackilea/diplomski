final Path basedir = Paths.get("/commits", commitId);

Files.createDirectories(basedir);

for (final String file: baseQueue)
    Files.copy(Paths.get(file), basedir.resolve(file));