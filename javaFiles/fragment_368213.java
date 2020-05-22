private static void increment(byte[] bcd) {
    for (int i = bcd.length - 1; i >= 0; i--) {
        byte b = bcd[i];
        if ((b & 0x0F) < 0x09) {
            bcd[i] = (byte)(b + 1);
            return;
        }
        if ((b & 0xF0) < 0x90) {
            bcd[i] = (byte)((b & 0xF0) + 0x10);
            return;
        }
        bcd[i] = 0;
    }
}