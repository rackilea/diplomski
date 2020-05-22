static int[][] DIRS = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

static boolean canGo(int[][] a, int n, int r, int c) {
    if (r < 0 || r >= n)
        return false;
    if (c < 0 || c >= n)
        return false;
    if (a[r][c] > 0)
        return false;
    return true;
}

static int[][] solve(int n) {
    int max = n * n;
    int[][] array = new int[n][n];
    int dir = 0, prev = 1, cur = 1;
    int row = 0, col = n - 1;
    for (int i = 1; i <= max; ++i) {
        array[row][col] = cur;
        if (!canGo(array, n, row + DIRS[dir][0], col + DIRS[dir][1]))
            dir = (dir + 1) % DIRS.length;
        row += DIRS[dir][0];
        col += DIRS[dir][1];
        int temp = cur;
        cur = prev + cur;
        prev = temp;
    }
    return array;
}