static class CountingInputStream extends FilterInputStream {
    private long bytesRead;

    protected CountingInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int result = super.read();
        if (result != -1) bytesRead += 1;
        return result;
    }
    @Override
    public int read(byte[] b) throws IOException {
        int result = super.read(b);
        if (result != -1) bytesRead += result;
        return result;
    }
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        if (result != -1) bytesRead += result;
        return result;
    }
    @Override
    public long skip(long n) throws IOException {
        long result = super.skip(n);
        if (result != -1) bytesRead += result;
        return result;
    }

    public long getBytesRead() {
        return bytesRead;
    }
}