void replace(int[] sorted, int oldValue, int newValue) {
    int oldI = Arrays.binarySearch(sorted, 0, sorted.length, oldValue);
    if (oldI < 0) { // Nothing to replace?
        return;
    }
    int newI = Arrays.binarySearch(sorted, 0, sorted.length, newValue);
    if (newI < 0) {
        newI = ~newI; // Insert position (when oldI not removed).
    }
    if (oldI < newI) { // oxxxx[n]
        --newI;
        System.arraycopy(sorted, oldI + 1, sorted, oldI, newI - oldI);
    } else if (oldI > newI) { // [n]xxxxo (newI points to first x).
        System.arraycopy(sorted, newI, sorted, newI + 1, oldI - newI);
    }
    sorted[newI] = newValue;
}