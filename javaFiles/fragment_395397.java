public float average(int... values) {
    float sum = 0;
    float usedValues = 0;
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