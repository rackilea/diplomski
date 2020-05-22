private static int runsTo(int[] vals, int index) {
    for (int i = index; i < vals.length - 1; i++) {
        if (vals[i] != vals[i + 1]) {
            return i;
        }
    }
    return vals.length;
}