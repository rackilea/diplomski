public void saveFile(File file) throw IOException {
    Path sourcePath = file.toPath();

    String fileName = file.getName();
    String targetPath = Paths.get("H:\\TestFolder", fileName);

    Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
}