float roundToUnevenMultiple(float x, float unit) {
    float remainder = x % unit;
    float y = x - remainder;
    int k = (int) (x / unit);
    if (k % 2 == 0) {
        y += unit;
    }
    return y;
}

float roundToEvenMultiple(float x, float unit) {
    float remainder = x % unit;
    float y = x - remainder;
    int k = (int) (x / unit);
    if (k % 2 == 1) {
        y += unit;
    }
    return y;
}