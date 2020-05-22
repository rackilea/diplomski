public static Path uniqueFile() {
    Path file = Paths.get("Library.txt").toAbsolutePath();
    if (!Files.exists(file))
        return file;

    Path folder = file.getParent();

    for (int counter = 2; true; counter++) {
        file = folder.resolve(String.format("Library (%d).txt", counter));

        if (!Files.exists(file))
            return file;
    }
}