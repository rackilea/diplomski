public static boolean[][] combinations(boolean kernel[][]) {
    int n = kernel.length;
    int m = kernel[0].length;
    int p = 1 << n;
    boolean[][] temp = new boolean[p][m];
    for (int i = 0; i < p; i++)
        for (int j = 0; j < n; j++)
            if (((1 << j) & i) != 0)
                for (int k = 0; k < m; k++)
                    temp[i][k] ^= kernel[j][k];
    return temp;
}