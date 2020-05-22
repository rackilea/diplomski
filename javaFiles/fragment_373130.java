private static void writeLine(OutputStream stream, String line) throws IOException {
    BufferedWriter writer = null;
    try {
        writer = new BufferedWriter(new InputStreamWriter(stream));
        writer.write(line + NEWLINE);
    } finally {
        if (writer != null)
            writer.close();
    }
}