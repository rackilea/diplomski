try (DirectoryStream<Path> dir = Files.newDirectoryStream(Paths.get("."))) {
    for (Path child : dir) {
        String filename = child.getFileName().toString();

        System.out.println("name=" + filename);
        for (char c : filename.toCharArray()) {
            System.out.printf("%04x ", (int) c);
        }
        System.out.println();
    }
}