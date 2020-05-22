public static InputStream foo(List<byte[]> binary) {
    byte[] all = new byte[binary.stream().mapToInt(a -> a.length).sum()];
    int pos = 0;
    for (byte[] bin : binary) {
        int length = bin.length;
        System.arraycopy(bin, 0, all, pos, length);
        pos += length;
    }
    return new ByteArrayInputStream(all);
}