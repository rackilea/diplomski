private byte[] splitKeyAlgorithm(byte[] key) {
    var lineLength = 55;
    int copyLength = key.length + key.length / lineLength;
    byte[] copy = new byte[copyLength];
    int ci = 0;
    for (int i = 0; i < key.length; i += lineLength) {
        int i2 = Math.min(i + lineLength, key.length);
        System.arraycopy(key, i, copy, ci, i2 - i);
        ci += i2 - i;
        if (ci < copy.length) {
            copy[ci++] = '\n';
        }
    }
    return copy;
}