private static int[][] findConsecutiveSequences(int[][] input) {
    int[] pos = new int[input.length];
    int nextValue = Integer.MIN_VALUE, value;
    List<int[]> results = new ArrayList<>();
    for (;;) {
        int[] result = new int[pos.length];
        for (int i = 0; i < pos.length; i++) {
            for (;;) {
                if (pos[i] == input[i].length)
                    return results.toArray(new int[results.size()][]);
                if ((value = input[i][pos[i]]) >= nextValue)
                    break;
                pos[i]++;
            }
            if (i == 0 || value == nextValue) {
                result[i] = value;
                nextValue = value + 1;
            } else {
                i = -1; // Restart with input[0]
            }
        }
        results.add(result);
    }
}