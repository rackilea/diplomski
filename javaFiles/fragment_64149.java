public static int tournamentTreeKSelection(int[] data, int k) {
    int max = -1;
    for (int i : data) {
        max = Math.max(max, i);
    }
    if (k == 1) {
        return max;
    }
    List<Integer> results = new ArrayList<>();
    for (int i : data) {
        if (i != max) {
            results.add(i);
        }
    }
    return tournamentTreeKSelection(listToArray(results), k - 1);
}