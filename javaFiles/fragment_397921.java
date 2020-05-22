class LongHashes {
    private static final LongHasher XOR_HASH = LongHashes::xorHash;
    private static final LongHasher CONTINUING_HASH = LongHashes::continuingHash;
    private static final LongHasher RANDOM_HASH = LongHashes::randomHash;

    static int xorHash(long x) {
        return (int)(x ^ (x >>> 32));
    }
    static int continuingHash(long x) {
        return (int)(x + (x >>> 32));
    }
    static int randomHash(long x) {
         return xorHash(x * 0x5DEECE66DL + 0xBL);
    }
}