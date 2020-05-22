private class MyOutputStream extends OutputStream {
    private long written = 0;
    private OutputStream inner;
    public MyOutputStream(OutputStream inner) {
        this.inner = inner;
    }
    public void close() {
        inner.close();
        updateTotals();
    }
    public void flush() {
        inner.flush();
    }
    public void write(byte[] b) {
        write(b, 0, b.length);
    }
    public void write(byte[] b, int off, int len) {
        inner.write(b, off, len);
        written += len;
    }
    public abstract void write(int b) {
        written ++;
        inner.write(b);
    }
}