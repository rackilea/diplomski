Path source = Paths.get("/my/full/path");
Path target = Paths.get("/new/path")
try {
    Files.move(source, target,
    StandardCopyOption.REPLACE_EXISTING);
} catch (IOException e) {
    e.printStackTrace();
}