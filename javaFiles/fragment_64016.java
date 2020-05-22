public static Integer[] retainAll(Integer[] a, Integer[] b) {
    int count = 0;
    for (Integer val : a) {
        if (contains(b, val)) {
            count++;
        }
    }
    Integer[] out = new Integer[count];
    count = 0;
    for (Integer val : a) {
        if (contains(b, val)) {
            out[count++] = val;
        }
    }
    return out;
}