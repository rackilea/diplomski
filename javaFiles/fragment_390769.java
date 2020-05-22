import java.util.*;
import java.lang.*;
import java.io.*;

class StrassenAlgo
{
    public int[][] recursiveMatrixMultipy (int A[][], int B[][], int a[][], int b[][], int n) {
        int c[][] = new int[n][n];
        if (n == 1) {
            c[0][0] = A[ a[0][0] ][ a[1][0] ] * B[ b[0][0] ][ b[1][0] ];
        } else {
            int [][] a11 = new int[2][2];
            int [][] a12 = new int[2][2];
            int [][] a21 = new int[2][2];
            int [][] a22 = new int[2][2];
            int [][] b11 = new int[2][2];
            int [][] b12 = new int[2][2];
            int [][] b21 = new int[2][2];
            int [][] b22 = new int[2][2];

            partitionMatrix (a, a11, a12, a21, a22);
            partitionMatrix (b, b11, b12, b21, b22);

            int s1[][] = substractMatrix (B, B, b12, b22);
            int s2[][] = addMatrix (A, A, a11, a12);
            int s3[][] = addMatrix (A, A, a21, a22);
            int s4[][] = substractMatrix (B, B, b21, b11);
            int s5[][] = addMatrix (A, A, a11, a22);
            int s6[][] = addMatrix (B, B, b11, b22);
            int s7[][] = substractMatrix (A, A, a12, a22);
            int s8[][] = addMatrix (B, B, b21, b22);
            int s9[][] = substractMatrix (A, A, a11, a21);
            int s10[][] = addMatrix (B, B, b11, b12);


            int ss[][] = {{0, s1.length - 1}, {0, s1.length - 1}};

            int p1[][] = recursiveMatrixMultipy (A, s1, a11, ss, n / 2);
            int p2[][] = recursiveMatrixMultipy (s2, B, ss, b22, n / 2);
            int p3[][] = recursiveMatrixMultipy (s3, B, ss, b11, n / 2);
            int p4[][] = recursiveMatrixMultipy (A, s4, a22, ss, n / 2);
            int p5[][] = recursiveMatrixMultipy (s5, s6, ss, ss, n / 2);
            int p6[][] = recursiveMatrixMultipy (s7, s8, ss, ss, n / 2);
            int p7[][] = recursiveMatrixMultipy (s9, s10, ss, ss, n / 2 );

            int pp[][] = {{0, p1.length - 1}, {0, p1.length - 1}};

            // c11 = p5 + p4 - p2 + p6
            int c11[][] = substractMatrix (addMatrix (p4, addMatrix (p5, p6, pp, pp), pp, pp), p2, pp, pp);
            // c12 = p1 + p2
            int c12[][] = addMatrix (p1, p2, pp, pp);
            // c21 = p3 + p4
            int c21[][] = addMatrix (p3, p4, pp, pp);
            // c22 = p5 + p1 - p3 - p7
            int c22[][] = substractMatrix(addMatrix (p1, p5, pp, pp), addMatrix(p3, p7, pp, pp), pp, pp);
            c = merge (c11, c12, c21, c22);
        }
        return c;
    }


    public int[][] addMatrix (int A[][], int B[][], int a[][], int b[][]) {
        int n = a[0][1] - a[0][0] + 1;
        int c[][] = new int[n][n];

        for (int i = a[0][0], u = b[0][0], x = 0; i <= a[0][1]; i++, u++, x++) {
            for (int j = a[1][0], v = b[1][0], y = 0; j <= a[1][1]; j++, v++, y++) {
                c[x][y] = A[i][j] + B[u][v];
            }
        }

        return c;
    }

    public int[][] substractMatrix (int A[][], int B[][], int a[][], int b[][]) {
        int n = a[0][1] - a[0][0] + 1;
        int c[][] = new int[n][n];

        for (int i = a[0][0], u = b[0][0], x = 0; i <= a[0][1]; i++, u++, x++) {
            for (int j = a[1][0], v = b[1][0], y = 0; j <= a[1][1]; j++, v++, y++) {
                c[x][y] = A[i][j] - B[u][v];
            }
        }

        return c;
    }

    public void partitionMatrix (int T[][], int t11[][], int t12[][], int t21[][], int t22[][]) {
        int r_start = T[0][0];
        int r_end = T[0][1];
        int c_start = T[1][0];
        int c_end = T[1][1];

        int r_mid = r_start + (r_end - r_start) / 2;
        int c_mid = c_start + (c_end - c_start) / 2;

        t11[0][0] = r_start;
        t11[0][1] = r_mid;
        t11[1][0] = c_start;
        t11[1][1] = c_mid;

        t12[0][0] = r_start;
        t12[0][1] = r_mid;
        t12[1][0] = c_mid + 1;
        t12[1][1] = c_end;

        t21[0][0] = r_mid + 1;
        t21[0][1] = r_end;
        t21[1][0] = c_start;
        t21[1][1] = c_mid;

        t22[0][0] = r_mid + 1;
        t22[0][1] = r_end;
        t22[1][0] = c_mid + 1;
        t22[1][1] = c_end;
    }

    public int[][] merge (int c11[][], int c12[][], int c21[][], int c22[][]) {
        int n_C = c11[0].length;
        int n = 2 * n_C;
        int C[][] = new int[n][n];
        for (int i = 0; i < n_C; i++) {
            for (int j = 0; j < n_C; j++) {
               C[i][j] = c11[i][j];
               C[i][j + n_C] = c12[i][j];
               C[i + n_C][j] = c21[i][j];
               C[i + n_C][j + n_C] = c22[i][j];
            }
        }
        return C;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        int matrix[][] = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};

        int n = matrix[0].length;

        if ((n > 0) && ( ( n & ( n - 1 ) ) == 0 ) ) {
            StrassenAlgo matrixDivAndConquer = new StrassenAlgo ();
            int a[][] = {{0, n - 1},{0, n  - 1}};
            int b[][] = {{0, n - 1},{0, n  - 1}};
            int C[][] = matrixDivAndConquer.recursiveMatrixMultipy 
            (matrix, matrix, a, b, n);
            System.out.println (Arrays.deepToString(C));
        }
    }
}