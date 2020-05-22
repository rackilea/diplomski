private static boolean contains(Integer[] a, Integer v) {
    for (Integer t : a) {
        if (t.equals(v)) {
            return true;
        }
    }
    return false;
}