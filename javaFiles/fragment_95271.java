private List<Path> getZipFiles() throws IOException {
    Path thisDir = Paths.get("src/test/resources");
    return Files.list(thisDir)
        .filter(p -> p.getFileName().toString().endsWith(".zip"))
        .collect(Collectors.toList());
// Alternative:
//    ArrayList<Path> result = new ArrayList<>();
//    try(DirectoryStream<Path> s = Files.newDirectoryStream(thisDir, "*.zip")) {
//        s.forEach(result::add);
//    }
//    return result;
}

@Test
public void test() throws IOException {
    getZipFiles().forEach(p -> ValidatorMain.main(p.toString()));
}