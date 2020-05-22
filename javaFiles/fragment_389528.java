private static int[][] findIncrementalSequences(int[][] input) {
    int[] pos = new int[input.length];
    int prevValue = Integer.MIN_VALUE;
    List<int[]> results = new ArrayList<>();
    for (;;) {
        int[] result = new int[pos.length];
        for (int i = 0; i < pos.length; i++) {
            while (pos[i] < input[i].length && input[i][pos[i]] <= prevValue)
                pos[i]++;
            if (pos[i] == input[i].length)
                return results.toArray(new int[results.size()][]);
            prevValue = result[i] = input[i][pos[i]];
        }
        results.add(result);
    }
}