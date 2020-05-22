/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    int bigA[][];
    int bigB[][];
    public Codechef (int bigA[][], int bigB[][]) {
        this.bigA = bigA;
        this.bigB = bigB;
    }

    public int[][] recursiveMatrixMultipy (int A[][], int B[][], int n) {
        int c[][] = new int[n][n];
        if (n == 1) {
            c[0][0] = bigA[ A[0][0] ][ A[1][0] ] * bigB[ B[0][0] ][ B[1][0] ];
        } else {
            int [][] a11 = new int[2][2];
            int [][] a12 = new int[2][2];
            int [][] a21 = new int[2][2];
            int [][] a22 = new int[2][2];
            int [][] b11 = new int[2][2];
            int [][] b12 = new int[2][2];
            int [][] b21 = new int[2][2];
            int [][] b22 = new int[2][2];

            partitionMatrix (A, a11, a12, a21, a22);
            partitionMatrix (B, b11, b12, b21, b22);

            int c11[][] = addMatrix(recursiveMatrixMultipy (a11, b11, n / 2),
                            recursiveMatrixMultipy (a12, b21, n / 2) );

            int c12[][] = addMatrix(recursiveMatrixMultipy (a11, b12, n / 2), 
                            recursiveMatrixMultipy (a12, b22, n / 2) );

            int c21[][] = addMatrix(recursiveMatrixMultipy (a21, b11, n / 2), 
                            recursiveMatrixMultipy (a22, b21, n / 2) );

            int c22[][] = addMatrix(recursiveMatrixMultipy (a21, b12, n / 2), 
                            recursiveMatrixMultipy (a22, b22, n / 2) );
            c = merge (c11, c12, c21, c22);
        }
        return c;
    }


    public int[][] addMatrix (int A[][], int B[][]) {
        int n = A[0].length;
        int c[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = A[i][j] + B[i][j];
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

        //checks if power of 2
        if ((n > 0) && ( ( n & ( n - 1 ) ) == 0 ) ) {
            Codechef matrixDivAndConquer = new Codechef (matrix, matrix);
            int A[][] = {{0, n - 1},{0, n  - 1}};
            int B[][] = {{0, n - 1},{0, n  - 1}};
            int C[][] = matrixDivAndConquer.recursiveMatrixMultipy (A, B, n);
            System.out.println (Arrays.deepToString(C));
        }
    }
}