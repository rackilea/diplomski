private static final int X_SIZE = 3;
private static final int Y_SIZE = 3;
private static int sumAdj(int x, int y, int[][] array) {
    int sum = 0;
    for (int i = Math.max(x-1, 0); i <= Math.min(x+1, X_SIZE -1); i++) {
        for (int j = Math.max(y-1, 0); j <= Math.min(y+1, Y_SIZE-1); j++) {
            sum += array[i][j];
        }
    }
    return sum;
}