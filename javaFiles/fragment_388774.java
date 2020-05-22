// Elsewhere
private static void runOnFile(String fileName, Consumer<FileInputStream> block1) {
    try (FileInputStream fis = new FileInputStream(fileName)) {
        block1.accept(fis);
    } catch (IOException e) {
        e.printStackTrace();
    }
}