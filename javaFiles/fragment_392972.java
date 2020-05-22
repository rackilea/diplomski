public double ih_comparehash(String hash_1, String hash_2, int maxlen) {
    int len = Math.min(hash_1.length() / 16, maxlen);
    BigInteger num1 = new BigInteger(hash_1.substring(0, 16 * len), 16);
    BigInteger num2 = new BigInteger(hash_2.substring(0, 16 * len), 16);
    int bitcnt = num1.xor(num2).bitCount();
    return ((64 * len) - bitcnt) * 100.0 / (64 * len);
}