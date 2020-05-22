int reverse(int x) {
    int y = 0;
    for (int i = 0; i < 32; ++i) {
        y <<= 1;       // make space
        y |= (x & 1);  // copy LSB of X into Y
        x >>>= 1;      // shift X right
    }
    return y;
}