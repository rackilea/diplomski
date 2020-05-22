Path path = Paths.get(
        "C:\\Users\\xxxxxx\\Desktop\\Utils\\YYYYY\\FN1.xls"));
// Or: Path path = file.toPath();

boolean isXlsx(Path path) {
    try (InputStream in = Files.newInputStream(path)) {
        byte[] magicCookie = new byte[2];
        return in.read(magicCookie) == 2
            && magicCookie[0] == 'P'
            && magicCookie[1] == 'K';
    } catch (IOException) {
        return false;
    }
}