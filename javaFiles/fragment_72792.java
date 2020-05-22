static long getLong(ByteBuffer bb, int numOfBytesToConvert) {
    switch (numOfBytesToConvert) {
        case 8:
            return bb.getLong();
        case 6:
            long aChar = bb.getChar();
            long anInt = bb.getInt() & 0xFFFFFFFFL;
            return bb.order() == ByteOrder.LITTLE_ENDIAN
                    ? aChar << 32 + anInt
                    : anInt << 16 + aChar;
        case 4:
            return bb.getInt() & 0xFFFFFFFFL;
        case 2:
            return bb.getChar();
        default:
            throw new IllegalArgumentException();
    }
}