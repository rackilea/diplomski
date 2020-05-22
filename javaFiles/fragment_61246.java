final int[] values = new int[256];
for (int i = 0; i < 256; ++i) {
    values[i] = (i & 0b1100_0000) >> 6
                | (i & 0b0011_0000) >> 2
                | (i & 0b0000_1100) << 2
                | (i & 0b0000_0011) << 6;
}