public static byte[] bitSubstringSlow(int startBitSource, int lengthInBits,
                                      byte... source) {
    byte[] target = new byte[(int) Math.ceil(lengthInBits / 8.0)];
    int startBitTarget = (8 - lengthInBits % 8) % 8;
    for (int i = 0; i < lengthInBits; ++i) {
        setBit(target, startBitTarget + i, getBit(source, startBitSource + i));
    }
    return target;
}

public static int getBit(byte[] source, int bitIdx) {
    return (source[bitIdx / 8] >>> (7 - bitIdx % 8)) & 1;
}

public static void setBit(byte[] target, int bitIdx, int bitValue) {
    int block = bitIdx / 8;
    int shift = 7 - bitIdx % 8;
    target[block] &= ~(1 << shift);
    target[block] |= bitValue << shift;
}