class NonCloseableOutputStream extends FilterOutputStream {

    public NonCloseableOutputStream(OutputStream out) {
        super(out);
    }

    @Override
    public void close() throws IOException {
        // ignore
    }
}