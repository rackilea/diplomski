public class MyInputStream extends InputStream {

    private final BufferedReader input;
    private final Charset encoding = StandardCharsets.UTF_8;
    private ByteArrayInputStream buffer;

    public MyInputStream(InputStream is) throws IOException {
        input = new BufferedReader(new InputStreamReader(is, this.encoding));
        nextLine();
    }

    @Override
    public int read() throws IOException {
        if (buffer == null) {
            return -1;
        }
        int ch = buffer.read();
        if (ch == -1) {
            if (!nextLine()) {
                return -1;
            }
            return read();
        }
        return ch;
    }

    private boolean nextLine() throws IOException {
        String line;
        while ((line = input.readLine()) != null) {
            line = filterLine(line);
            if (line != null) {
                line += '\n';
                buffer = new ByteArrayInputStream(line.getBytes(encoding));
                return true;
            }
        }
        return false;
    }

    @Override
    public void close() throws IOException {
        input.close();
    }

    private String filterLine(String line) {
        // Filter the line here ... return null to skip the line
        // For example:
        return line.replace("ABC", "XYZ");
    }

}