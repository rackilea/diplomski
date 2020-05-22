public class SquareMatrix {

public static void main(String[] args) {
    //int[] D1 = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    int[] D1 = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    //int[] D1 = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
    int n = 5;
    int[][] m = new int[n][n];

    int cnt = 0;
    // The top right part of the matrix (values 1-15 in a 5x5 scenario)
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < i; j++) {
            m[j][n+j-i] = D1[cnt++];
        }
    }
    // The bottom left of the matrix (values 16-25 in a 5x5 scenario)
    for (int i = n-1; i >= 1; i--) {
        for (int j = i; j >= 1; j--) {
            m[n-j][i-j] = D1[cnt++];
        }
    }
    printMatrix(m);
}

static void printMatrix(int[][] m) {
    for (int i = 0; i<m.length; i++) {
        for (int j = 0; j<m.length; j++) {
            System.out.printf("%2d ", m[i][j]);
        }
        System.out.println();
    }
}

}