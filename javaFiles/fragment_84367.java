void updateMaterialsFile(int updatedLineno, String updated) throws IOException {
    Path materialsPath = Paths.get("Materials.txt");
    Path tempPath = materialsPath.resolveSibling("temp.txt");

    try (Stream<String> lines = Files.lines(materialsPath);
            BufferedWriter fw = Files.newBufferedWriter(tempPath)) {

        AtomicInteger lineno = new AtomicInteger();
        lines.forEach(line -> {
            int lno = lineno.getAndIncrement();
            try {
                fw.write(lno == updatedLineno ? updated : line);
                fw.write("\r\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    } catch (RuntimeException e) {
        throw new IOException(e.getCause());
    }
    Files.move(tempPath, materialsPath, StandardCopyOption.REPLACE_EXISTING);
}