class CountingInputStream extends InputStream {
    final InputStream is;
    int counter = 0;

    public CountingInputStream(InputStream is) {
        this.is = is;
    }

    public int read() throws IOException {
        int read = is.read();
        if (read >= 0) counter++;
        return read;
    }
}