public int solution(int[] A) {
    final int solution[] = {1};
    Arrays.stream(A)
            .filter(i -> i > 0)
            .sorted()
            .forEach(i -> {
                if (i == solution[0]) {
                    solution[0]++;
                }
            });
    return solution[0];
}