try {
    byte[] hash = getHash(tohash);
    System.arraycopy(hash, 0, data, 0, 15);
} catch (NoSuchAlgorithmException e) {
    e.printStackTrace();
} catch (UnsupportedEncodingException e) {
    e.printStackTrace();
}