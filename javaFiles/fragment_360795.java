int[][] grid = {
    {1, 0, 1, 0},
    {0, 0, 0, 0},
    {0, 1, 0, 1},
};
long onesCount = Arrays.stream(grid)
    .flatMapToInt(IntStream::of)
    .sum();
System.out.println(onesCount);  // -> 4