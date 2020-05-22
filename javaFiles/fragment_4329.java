public final ByteBuffer encode(CharBuffer in)
    throws CharacterCodingException
{
    int n = (int)(in.remaining() * averageBytesPerChar());
    ByteBuffer out = ByteBuffer.allocate(n);
    ...