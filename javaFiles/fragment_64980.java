public byte[] GetKeyAsBytes(String key) {
    byte[] keyBytes = new byte[24]; // a Triple DES key is a byte[24] array

    for (int i = 0; i < key.length() && i < keyBytes.length; i++) 
        keyBytes[i] = (byte) key.charAt(i);

    return keyBytes;
}