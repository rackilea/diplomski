ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
byte[] arg1 = new byte[] { 0x04, (byte) 0xB0 };
for (int i = 0; i < Long.BYTES; i++) {
    int pos = Long.BYTES - i - 1;
    byte val = (pos < arg1.length) ? arg1[pos] : 0;
    buffer.put(val);
}
buffer.flip();
long val = buffer.getLong();
System.out.println(val);