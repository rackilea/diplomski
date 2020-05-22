public static float getLowestRoot(float A, float B, float C) {
    float D = B*B - 4*A*C;

    if (D < 0) return 1;

    if (Math.abs(D) < 0.0001)  // not sure how many 0s for float
    {
        float x = -B / (2*A);

        if (x > 0 && x < 1) return x;

        return 1;
    }

    float sD = (float) Math.sqrt(D);

    int signA = Math.signum(A);
    float x1 = (-B + -signA * sD) / (2*A);
    float x2 = (-B + signA * sD) / (2*A);

    if (x1 > 0 && x1 < 1) return x1;
    if (x2 > 0 && x2 < 1) return x2;

    return 1;
}