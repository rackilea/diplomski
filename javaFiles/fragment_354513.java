private static int[][] multiply(int[][] n, int m) {
    int array[][] = new int[n.length][];
    for (int i = 0; i < n.length; i++) {
        array[i] = new int[n[i].length];
        for (int j = 0; j < n[i].length; j++) {
            array[i][j] = n[i][j] * m;
        }
    }
    return array;
}