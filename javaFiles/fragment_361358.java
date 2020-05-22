public static long checkSum(byte[] buffer, int offset, int length) {
    long cs = 0;
    for (int i = offset; i < offset + length & i < buffer.length; i += 2) {

        ByteBuffer bb = ByteBuffer.allocate(2);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.put(buffer[i]);
        bb.put(buffer[i+1]);
        long shortVal = bb.getShort(0);
        if (shortVal < 0) { shortVal += (1 << 16); }
        cs += shortVal;
    }
    return cs;
}