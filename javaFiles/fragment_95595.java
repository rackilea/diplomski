public static int unsignedToBytes(byte b) {
    return b & 0xFF;
  }

  public static void main(String[] args) {
    System.out.println(unsignedToBytes((byte) -12));
  }