public static boolean[] booleanArrayFromByte(byte x) {
    boolean bs[] = new boolean[4];
    bs[0] = ((x & 0x01) != 0);
    bs[1] = ((x & 0x02) != 0);
    bs[2] = ((x & 0x04) != 0);
    bs[3] = ((x & 0x08) != 0);
    return bs;
}