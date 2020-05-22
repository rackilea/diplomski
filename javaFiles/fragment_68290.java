public class ServletOutputStreamCopier extends ServletOutputStream {

    private ServletOutputStream outputStream;
    private ByteArrayOutputStream copier;

    /**
     * 
     */
    public ServletOutputStreamCopier(ServletOutputStream outputStream) {
        super();
        this.outputStream = outputStream;
        this.copier = new ByteArrayOutputStream();
    }

    @Override
    public boolean isReady()
    {
        return this.outputStream.isReady();
    }

    @Override
    public void setWriteListener(WriteListener listener)
    {

    }

    @Override
    public void write(int b) throws IOException
    {
        if (this.copier == null)
            this.copier = new ByteArrayOutputStream();
        if (this.outputStream == null)
            throw new IOException("outputStream is null");
        this.copier.write(b);
        this.outputStream.write(b);

    }

    public byte[] getCopyBuffer()
    {
        return this.copier.toByteArray();
    }

}