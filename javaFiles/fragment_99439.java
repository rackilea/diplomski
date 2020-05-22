public static void main(String[] args) throws Exception {
    byte[] bytearray = {0x02, 0x08, 0x16, 0x00, 0x00, 0x33, (byte)0xC6, 0x1B};
    for (byte b : bytearray) {
        System.out.printf("%d ", b);
    }
    System.out.println();

    for (byte b : bytearray) {
        System.out.printf("%d ", b & 0xFF);
    }
}