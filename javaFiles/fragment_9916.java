private static byte[] getCRC16LowHighBytes(byte[] byteSequence) {
    // Create a byte array for Low and High bytes
    byte[] returnBytes = new byte[2];
    int crc = CRC16_SEED;
    for (int i = 0; i < byteSequence.length; ++i) {
        crc ^= (byteSequence[i] << 8);
        for (int j = 0; j < 8; ++j) {
            if ((crc & 0x8000) != 0) {
                crc = (crc << 1) ^ CRC16_POLINOM;
            } else {
                crc <<= 1;
            }
        }
    }
    byte[] crcBytes = getBytes(crc);
    // The first two bytes of crcBytes are low and high bytes respectively.
    for (int i = 0; i < returnBytes.length; i++) {
        returnBytes[i] = crcBytes[i];
    }
    return returnBytes;
}

private static byte[] getBytes(int v) {
    byte[] writeBuffer = new byte[4];
    writeBuffer[3] = (byte) ((v >>> 24) & 0xFF);
    writeBuffer[2] = (byte) ((v >>> 16) & 0xFF);
    writeBuffer[1] = (byte) ((v >>> 8) & 0xFF);
    writeBuffer[0] = (byte) ((v >>> 0) & 0xFF);
    return writeBuffer;
}