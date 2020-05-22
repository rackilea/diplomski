public class BigMultiPartEntity extends MultipartEntity {

private ProgressListener listener;

public BigMultiPartEntity(final HttpMultipartMode mode, final ProgressListener listener)
{
    super(mode);
    this.listener = listener;
}

public BigMultiPartEntity(HttpMultipartMode mode, final String boundary, final Charset charset, final ProgressListener listener)
{
    super(mode, boundary, charset);
    this.listener = listener;
}

@Override
public void writeTo(final OutputStream outstream) throws IOException
{
    super.writeTo(new CountingOutputStream(outstream, this.listener));
}

public interface ProgressListener {
    void transferred(int num);
}

public class CountingOutputStream extends FilterOutputStream
{
    private ProgressListener listener;
    private int transfered;

    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field <tt>this.out</tt> for later use, or
     *            <code>null</code> if this instance is to be
     *            created without an underlying stream.
     */
    public CountingOutputStream(OutputStream out, ProgressListener listener) {
        super(out);
        this.listener = listener;
        this.transfered = 0;
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.transfered += len;
        //Log.d(TAG, "writing...transfer @ "+transfered);
        this.listener.transferred((int) ((transfered / (float) getContentLength()) * 100));
        out.write(b, off, len);


    }

    @Override
    public void write(int b) throws IOException {
        this.transfered += b;
        //Log.d(TAG, "writing...transfer @ "+transfered);
        this.listener.transferred((int) ((transfered / (float) getContentLength()) * 100));
        out.write(b);
    }
}
}