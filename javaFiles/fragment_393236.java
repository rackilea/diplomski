public static byte[] bitSubstringSlow2(int startBitSource, int lengthInBits,
                                       byte... source) {
    byte[] target = new byte[(int) Math.ceil(lengthInBits / 8.0)];
    int startBitTarget = (8 - lengthInBits % 8) % 8;
    for (int i = 0; i < lengthInBits; ++i) {
        int srcIdx = startBitSource + i;
        int tgtIdx = startBitTarget + i;
        target[tgtIdx / 8] |= ((source[srcIdx / 8] >>> (7 - srcIdx % 8)) & 1)
                              << (7 - tgtIdx % 8);
    }
    return target;
}