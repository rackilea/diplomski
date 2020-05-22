byte[] bytes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe};

// now shift left
byte b0 = bytes[0];
System.arraycopy(bytes, 1, bytes, 0, bytes.length -1);
bytes[bytes.length - 1] = b0;