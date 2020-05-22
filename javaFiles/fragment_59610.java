Pattern pattern = Pattern.compile("TEXT_TO_SEARCH");
Charset charset = Charset.defaultCharset();

long count = 0;

try (DirectoryStream<Path> dir =
    Files.newDirectoryStream(Paths.get("/home/talha"))) {

    for (Path file : dir) {
        count += Files.lines(file, charset).filter(pattern.asPredicate()).count();
    }
}