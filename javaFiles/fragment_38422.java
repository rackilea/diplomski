public static byte setParameters(int b1, int b2, int b3, int b4) {
    byte result = (byte) b1;
    result |= (b2 << 1) & 0x02;
    result |= (b3 << 2) & 0x0c;
    result |= (b4 << 4) & 0xf0;
    return result;
}