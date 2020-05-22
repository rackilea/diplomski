class ResetOnCloseInputStream extends InputStream {

    private final InputStream decorated;

    public ResetOnCloseInputStream(InputStream anInputStream) {
        if (!anInputStream.markSupported()) {
            throw new IllegalArgumentException("marking not supported");
        }

        anInputStream.mark( 1 << 24); // magic constant: BEWARE
        decorated = anInputStream;
    }

    @Override
    public void close() throws IOException {
        decorated.reset();
    }

    @Override
    public int read() throws IOException {
        return decorated.read();
    }
}