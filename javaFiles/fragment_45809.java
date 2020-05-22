try (BufferedWriter w = new BufferedWriter
    (new OutputStreamWriter(
        new FileOutputStream(outFile), "utf-8"))) {
    w.write("Test string");
    w.newLine();
} catch (IOException ex) {
    ex.printStackTrace();
}