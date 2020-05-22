private byte xorWithKey(byte a, byte[] key) {
byte out=a;
for (int i = 0; i < key.length; i++) {
    out = (byte) (out ^ key[i]);
}
return out;
}