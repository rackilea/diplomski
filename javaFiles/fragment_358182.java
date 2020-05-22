public static byte[] encodeAsSysExUnsigned(int value, final int maxValue) {
    if (value > maxValue || value < 0)
        throw new IllegalArgumentException(String.format("Value %d out of range [0 .. %d]", value, maxValue));
    final int dataLength = getDataLengthUnsigned(maxValue);
    final byte[] sysExData = new byte[dataLength];
    for (int i = 0; i < dataLength; i++, value >>>= 7)
        sysExData[i] = (byte) (value & 0x7F);
    return sysExData;
}