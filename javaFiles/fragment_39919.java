paths.forEach(folderPath -> {
    Path to = folderPath.getParent();
    try {
        try(Stream<Path> files = Files.list(folderPath)) {
            files.forEach(filePath -> {
                try{Files.move(filePath, to.resolve(filePath.getFileName()), ATOMIC_MOVE);}
                catch (IOException e) { processException(e); }
            });
        }
        try {
            Files.deleteIfExists(folderPath);
        } catch(DirectoryNotEmptyException ex) {
            // may happen as you continue when Files.move fails,
            // but you already reported the original exception then
        }
    } catch (IOException e) { processException(e); }
});