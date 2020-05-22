public static boolean isBitSet(byte b, int bitNo) {
    return (b & (1 << bitNo) != 0;
}

public static byte setBit(byte b, int bitNo) {
    return (byte) (b | (1 << bitNo));
}

public static byte clearBit(byte b, int bitNo) {
    return (byte) (b & (~(1 << bitNo)));
}