private static int[] removeDups(int[] a, int maxA) {
    boolean[] present = new boolean[maxA+1];
    int countUnique = 0;
    for (int i : a) {
        if (!present[i]) {
            countUnique++;
            present[i] = true;
        }
    }

    int[] result = new int[countUnique];
    int j = 0;
    for (int i=0; i<present.length; i++) {
        if (present[i]) result[j++] = i;
    }

    return result;
}