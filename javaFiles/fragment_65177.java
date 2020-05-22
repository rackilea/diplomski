public int search(int[] values, int z) {
    int start = 0;
    int end = values.length-1;

    if (values[0] == z)
         return 0;
    else if (values[end] == z) {
        return end;
    }

    boolean interpolation = true;

    while (start < end) {
        int mid;
        if (interpolation) {
            mid = start + ((z - values[start]) * (end - start)) / (values[end] - values[start]);
        } else {
            mid = (end-start) / 2;
        }
        int v = values[mid];
        if (v == z)
            return mid;
        else if (v > z)
            end = mid;
        else
            start = mid;
        interpolation = !interpolation;
    }
    return -1;
}