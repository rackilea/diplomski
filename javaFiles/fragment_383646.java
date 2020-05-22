// GC-less method.
public void writeAsciiText(ByteBuffer bb, String text) {
    assert text.length() < (1 << 16);
    bb.putShort((short) text.length());
    for(int i=0;i<text.length();i++)
        bb.put((byte) text.charAt(i));
}