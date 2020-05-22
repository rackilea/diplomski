final Path baseDir = Paths.get("whever");

final List<Path> entries = new ArrayList<>();

for (final Path entry: Files.newDirectoryStream(baseDir))
    entries.add(entry);

Collections.sort(entries, CREATION_TIME_COMPARATOR);