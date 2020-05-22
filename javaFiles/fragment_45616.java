public final class Message
{
    private static final MESSAGE_SIZE = 4;
    private static final PORT_OFFSET=3;

    private final ByteBuffer buf;

    public Message()
    {
        buf = ByteBuffer.allocate(MESSAGE_SIZE);
    }

    public void setPort(final byte b)
    {
        buf.put(PORT_OFFSET, b);
    }

    // etc

    public byte[] getRaw()
    {
        return buf.array();
    }
}