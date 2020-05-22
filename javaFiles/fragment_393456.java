public static int[][] build2(int row, int col) {
    int[][] arr2 = new int[row][col];
    for (int i = 0; i < arr2.length; i++) {
        arr2[i] = build1(col);
    }
    return arr2;
}