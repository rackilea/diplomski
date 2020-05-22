byte[] longToBytes(long x) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    int mask = 1;
    for (int i = 0; i < 8; ++i) {
        if ((mask & x) != 0) {
            baos.write(0xFF & (int)mask);
        }
        mask <<= 1;
    }
    return baos.toArray();
}