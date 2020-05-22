private static final String NEWLINE = System.getProperty("line.separator");

public static void main(String[] args) throws IOException {
    String file = "foo/bar.txt";
    FileOutputStream stream = null;
    try {
        stream = new FileOutputStream(file);
        writeLine(stream, "Line 1");
        writeLine(stream, "Line 2");
    } finally {
        if (stream != null)
            stream.close();
    }
}

private static void writeLine(OutputStream stream, String line) throws IOException {
    BufferedWriter writer = new BufferedWriter(new InputStreamWriter(stream));
    writer.write(line + NEWLINE);
}