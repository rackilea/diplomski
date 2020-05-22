/**
 * Magic number that is written to the stream header.
 */
final static short STREAM_MAGIC = (short)0xaced;
...
protected void writeStreamHeader() throws IOException {
    bout.writeShort(STREAM_MAGIC);
    bout.writeShort(STREAM_VERSION);
}