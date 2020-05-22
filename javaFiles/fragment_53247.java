final Path folder = Paths.get("...");

// no limitation in the walking depth 
Files.walkFileTree(folder, visitor);

// limit the walking depth to 1 level
Files.walkFileTree(folder, new HashSet<>(), 1, visitor);