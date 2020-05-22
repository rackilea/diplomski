public static byte[] bitSubstring(int startBit, int lengthInBits,
                                  byte... source) {
    assert startBit >= 0 && startBit < 8 * source.length;
    assert lengthInBits >= 0 && startBit + lengthInBits <= 8 * source.length;

    int lengthInBytes = (int) Math.ceil(lengthInBits / 8.0);
    byte[] target = new byte[lengthInBytes];
    int startByte = startBit / 8;
    int endBitExclusive = startBit + lengthInBits;
    int endByteExclusive = (int) Math.ceil(endBitExclusive / 8.0);
    int sourceBytesToRead = endByteExclusive - startByte;
    int lowerPartSize = 8 * endByteExclusive - endBitExclusive;
    int shiftLowerUp = (8 - lowerPartSize);
    int shiftUpperDown = lowerPartSize;
    int lastSrc = 0;
    if (sourceBytesToRead > lengthInBytes) {
        lastSrc = source[startByte] & 0xFF;
        startByte++;
    }
    for (int targetByte = 0; targetByte < target.length; ++targetByte) {
        int curSrc = source[startByte + targetByte] & 0xFF;
        target[targetByte] |= (lastSrc << shiftLowerUp)
                            | (curSrc >>> shiftUpperDown);
        lastSrc = curSrc;
    }
    int overhang = 8 * lengthInBytes - lengthInBits;
    if (overhang > 0) {
        target[0] &= 0xFF >>> overhang;
    }
    return target;
}