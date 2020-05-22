class MultiWriter extends Writer {

    private final Writer[] writers;

    public MultiWriter(Writer... writers) {
        this.writers = writers;
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (Writer w : writers)
            w.write(cbuf, off, len);
    }

    @Override
    public void flush() throws IOException {
        for (Writer w : writers)
            w.flush();
    }

    @Override
    public void close() throws IOException {
        for (Writer w : writers)
            w.close();
    }

};