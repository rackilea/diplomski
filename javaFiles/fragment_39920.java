paths.forEach(folderPath -> {
    Path to = folderPath.getParent();
    try {
        boolean allMovesSucceeded;
        try(Stream<Path> files = Files.list(folderPath)) {
          allMovesSucceeded = files
            .map(filePath -> {
                try {
                    Files.move(filePath, to.resolve(filePath.getFileName()), ATOMIC_MOVE);
                    return true;
                }
                catch(IOException e) { processException(e); return false; }
            }).reduce(Boolean.TRUE, Boolean::logicalAnd);

        }
        if(allMovesSucceeded) Files.deleteIfExists(folderPath);
    } catch (IOException e) { processException(e); }
});