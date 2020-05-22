public static byte[] adjustDESParity(final byte[] keyData) {
    for (int i = 0; i < keyData.length; i++) {
        // count the bits, and XOR with 1 if even or 0 if already odd 
        keyData[i] ^= (Integer.bitCount(keyData[i]) % 2) ^ 1;
    }
    return keyData;
}