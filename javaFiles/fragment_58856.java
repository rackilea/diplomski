class MyWriterWrapper extends Writer {

    private Writer realWriter;
    private int bytesWritten;

    public MyWriterWrapper(Writer realWriter) {
        super(); 
        this.realWriter = realWriter;
    }

    public int getBytesWritten() {
        return bytesWritten;
    }

    @Override
    public Writer append(CharSequence csq) throws IOException {
         realWriter.append(csq);
         bytesWritten += csq.length();
         return this;
    }

    // Implement/Override all other Writer methods the same way

}