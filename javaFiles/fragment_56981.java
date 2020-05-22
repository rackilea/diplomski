Path dir = Paths.get("C:\\"); // directory to list

try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
    for (Path entry: stream) {
        System.out.println(entry);
    }
} catch (DirectoryIteratorException ex) {
    ex.printStackTrace();
} catch (IOException ex) {
    ex.printStackTrace();
}