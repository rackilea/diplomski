public class HackedReader extends BufferedReader {

    public HackedReader(InputStreamReader inputStreamReader) {
        super(inputStreamReader);
    }

    @Override
    public void close() {
        // Close method doesn't do anything, that's the main sense of overriding.
    }

    // But you know exact method which will close your underlying stream.
    public void hackedClose() throws IOException {
        super.close();
    }
}