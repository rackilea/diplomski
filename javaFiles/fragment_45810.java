try (BufferedWriter w = new BufferedWriter
    (new OutputStreamWriter(
        new FileOutputStream(outFile), "utf-8"))) {
    writeEverythingINeed(w);
} catch (IOException ex) {
    ex.printStackTrace();
}