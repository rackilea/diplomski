public static int[][] Transpose2D(int m[][]) {
   int B[][] = new int[m[0].length][m.length];

    for (int i = 0; i < m.length; i++) {
        for (int j = 0; j < m[0].length; j++) {
            B[j][i] = m[i][j];
        }
    }
    return B;
}