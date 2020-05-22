public static int strtoul(byte[] bytes, int size, int base) {
    int total = 0;
    for (int i = 0; i < size; i++) {
        if (base == 16) {
            // signed bytes, shifted
            total += bytes[i] << (size - 1 - i) * 8;
        } else {
            // unsigned bytes, shifted
            total += (bytes[i] & 0xff) << (size - 1 - i) * 8;
        }
    }
    return total;
}