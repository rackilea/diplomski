float roundToUnevenMultiple(float x, float unit) {
    int k = (int) (x / unit);
    if (k % 2 == 0) {
        ++k; // Upper half
    }
    return k * unit;
}