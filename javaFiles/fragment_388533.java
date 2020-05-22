public final void writeShortstr(String str)
    throws IOException
{
    byte [] bytes = str.getBytes("utf-8");
    int length = bytes.length;
    if (length > 255) {
        throw new IllegalArgumentException(
            "Short string too long; utf-8 encoded length = " + length +
            ", max = 255.");
    }
    out.writeByte(bytes.length);
    out.write(bytes);
}