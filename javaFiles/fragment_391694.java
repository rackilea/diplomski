public int compare(Integer a, Integer b) {
    int diff = Math.abs(a - pivot) - Math.abs(b - pivot);
    if (diff != 0) {
        return diff;
    }
    return a - b;
}