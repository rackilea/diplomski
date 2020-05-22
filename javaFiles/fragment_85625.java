public final class ByteBufferOutputStream
    extends OutputStream
{
    private final ByteBuffer buf;

    public ByteBufferOutputStream(final int size)
    {
        buf = ByteBuffer.allocateDirect(size);
    }

    @Override
    public void write(final int b)
        throws IOException
    {
        if (buf.remaining() == 0)
            throw new IOException("buffer is full");
        buf.put((byte) (b & 0xff));
    }
}