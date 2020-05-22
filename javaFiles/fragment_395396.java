public float averageSix(int a, int b, int c, int d, int e, int f) {
    float sum = 0;
    float usedValues = 0;
    int[] values = new int[]{a, b, c, d, e, f};
    for (int value : values) {
        if (value >= 0) {
            usedValues++;
            sum += value;
        }
    }

    float average = -1;
    if (sum > 0) {
        average = sum / usedValues;
    }

    return average;
}