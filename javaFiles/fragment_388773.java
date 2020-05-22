private static void method1(String filename, int sheetNum) {
    runOnFile(filename, (fileStream) -> {
        doStuffWithStream(fileStream);
        doOtherStuffWithStream(fileStream);
    });
}

// Elsewhere
private static void runOnFile(String fileName, Consumer<FileInputStream> block1) {
    try {
        fileStream = new FileInputStream(fileName);
    } catch (IOException e) {
        e.printStackTrace();
    }

    block1.accept(fileStrean);

    fileStream.close();
}