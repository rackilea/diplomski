public static void main(String[] args) throws IOException {
    byte[] ints = {0x00, 0x00, 0x00, (byte) 0xFF,
                    (byte) 0xAA, (byte) 0xBB, (byte) 0xEE, (byte) 0xFF};
    ByteArrayInputStream array = new ByteArrayInputStream(ints);
    BufferedInputStream buffer = new BufferedInputStream(array);
    DataInputStream data = new DataInputStream(buffer);
    while(hasData(data)) {
      int reversed = Integer.reverseBytes(data.readInt());
      System.out.format("%08x%n", reversed);
    }
  }

  public static boolean hasData(InputStream in) throws IOException {
    in.mark(1);
    try {
      return in.read() != -1;
    } finally {
      in.reset();
    }
  }