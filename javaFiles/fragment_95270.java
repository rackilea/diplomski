private Stream<Path> getZipFiles() throws IOException {
    Path thisDir = Paths.get("src/test/resources");
    return Files.list(thisDir).filter(p -> p.getFileName().toString().endsWith(".zip"));
}

@Test
public void test() throws IOException {
    try(Stream<Path> s=getZipFiles()) {
        s.map(Object::toString).forEach(ValidatorMain::main);
    }
}