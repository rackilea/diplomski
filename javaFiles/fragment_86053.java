public static byte[] computeInverseTable() {
    byte [] inverseTable = new byte[16];
    inverseTable[0] = 0; // the inverse of 0 doesn't exist.

    for (int x = 1; x<16; x++) {
        for (int y = 1; y<16; y++) {
            if (mulTable[x][y] == 1) {
                inverseTable[x] = (byte) y;
                break;
            }
        }
    }
    return inverseTable;
}