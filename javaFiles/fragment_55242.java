import java.util.Random;

public class Matrix1 {

private final int[][] matrix;
private final int n;

public Matrix1(int n) {
    this.n = n;
    this.matrix = new int[n][n];
}

/**
 * randomly fill in 0s and 1s
 */
public void fill() {
    Random rand = new Random();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            matrix[i][j] = rand.nextInt(2);
        }
    }
}

/**
 * print the matrix, each row is printed in a separate line
 */
public void print() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.print(matrix[i][j]);
        }
        System.out.println();
    }
}

public static void main(String[] args) {
    Matrix1 matrix = new Matrix1(5);
    matrix.fill();
    matrix.print();
}

}