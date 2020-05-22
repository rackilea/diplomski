float roundToEvenMultiple(float x, float unit) {
    int k = (int) (x / unit);
    if (k % 2 == 1) {
        ++k; // Upper half
    }
    return k * unit;
}