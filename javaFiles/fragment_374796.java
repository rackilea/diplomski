public int nextInRange(int last, int min, int max, int delta) {
    int result = last + delta;

    // now clip to min and max
    if (result > max) {
        result = max;
    } else if (result < min) {
        result = min;
    }

    return result;
}