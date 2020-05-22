public void transformFile(File in, File out) throws IOException {

    /*
     * This method allocates the resources needed to perform the operation
     * and releases them once the operation is done. This mechanism is know
     * as a try-with-resource. After the try statement exits, the resources
     * are closed
     */

    try (BufferedReader bin = new BufferedReader(new FileReader(in));
            Writer bout = new FileWriter(out)) {

        transformBufferedReader(bin, bout);
    }
}

private void transformBufferedReader(BufferedReader in, Writer out) throws IOException {
    /*
     * This method iterates over the lines in the reader and figures out if
     * it should be written to the file
     */

    String line = null;
    while ((line = in.readLine()) != null) {
        if (isWriteLine(line)) writeLine(line, out);
    }
}

private boolean isWriteLine(String line) throws IOException {

    /*
     * This tests if the line should be written
     */

    return !line.matches("ALL|MESSAGE|Time|PAPER_MAIN|GSP");
}

private void writeLine(String line, Writer writer) throws IOException {

    /*
     * Write a line out to the writer
     */

    writer.append(line);
    writer.append('\n');
}