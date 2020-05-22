Path source = Paths.get("Bar");
Path target = Paths.get("Foo", "Bar");
try {
    Files.move(
        source,
        target,  
        StandardCopyOption.REPLACE_EXISTING);
} catch (IOException e) {
    e.printStackTrace();
}