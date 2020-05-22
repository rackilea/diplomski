byte[] key;
if (keyBytes.length == 16) {
    key = new byte[24];
    System.arraycopy(keyBytes, 0, key, 0, 16);
    System.arraycopy(keyBytes, 0, key, 16, 8);
} else {
    key = keyBytes;
}