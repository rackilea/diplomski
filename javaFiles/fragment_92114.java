int i = 123456; // <== change the value
System.out.format("Bytes of %d: ", i);
byte[] bytes = ByteBuffer.allocate(4).putInt(i).array();
for (byte b : bytes) {
   System.out.format("0x%x ", b);
}
System.out.format("\nlast two bytes : %d*256 + %d = %d\n", bytes[2], bytes[3], (short)(bytes[2]*256 + bytes[3]));