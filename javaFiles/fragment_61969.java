private static double readLEShort(RandomAccessFile f) {
try {
    byte b1 = (byte) f.read();
    byte b2 = (byte) f.read();
    return (double) (b2 << 8 | b1 & 0xFF) / 32767.0;
} catch (IOException e) {
    e.printStackTrace();
}
return 0;
}