byte[] ints = {0x00, 0x00, 0x00, (byte) 0xFF,
               (byte) 0xAA, (byte) 0xBB, (byte) 0xEE, (byte) 0xFF};
ByteArrayInputStream array = new ByteArrayInputStream(ints);
DataInputStream data = new DataInputStream(array);
while(data.available() > 0) {
  int reversed = Integer.reverseBytes(data.readInt());
  System.out.format("%08x%n", reversed);
}