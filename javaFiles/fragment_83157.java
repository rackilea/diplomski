Path sourceDir = Paths.get("c:\\source");
    Path destinationDir = Paths.get("c:\\dest");

    try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourceDir)) {
        for (Path path : directoryStream) {
            System.out.println("copying " + path.toString());
            Path d2 = destinationDir.resolve(path.getFileName());
            System.out.println("destination File=" + d2);
            Files.move(path, d2, REPLACE_EXISTING);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }