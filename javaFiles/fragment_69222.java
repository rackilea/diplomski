byte[] parseHex(String str) {
    byte[] a = new BigInteger(str, 16).toByteArray();
    if (a.length != str.length() / 2) {
        a = Arrays.copyOfRange(a, 1, a.length);
    }
    return a;
}