import java.util.Random;

public class SquareDiagonalNumbers {
    private static int positive = 0;
    private static int negative = 0;

    private static int n = 8;

    private static int positiveOnes = n * 75 / 100; //75%
    private static int negativeOnes = n * 25 / 100; //25%

    private static int a = 10;
    private static int b = 20;

    public static void main(String[] args) {
        int[][] array = new int[n][n];

        int products = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = i == j || i == (n - j - 1) ? randomOnes() : randomNumber();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] < i * j) {
                    products++;
                    System.out.println("At [" + i + ", " + j + "] number " + array[i][j] + " is lower than [i * j]: " + (i * j));
                }
            }
        }

        System.out.println("Total of numbers lower than the product of their row and column: " + products);
    }

    private static int randomNumber() {
        Random r = new Random();
        return r.nextInt(b - a) + a;
    }

    private static int randomOnes() {
        Random r = new Random();
        boolean isPositive = r.nextBoolean();

        if (isPositive) {
            if (positive < positiveOnes) {
                positive++;
                return 1;
            } else {
                negative++;
                return -1;
            }
        } else {
            if (negative < negativeOnes) {
                negative++;
                return -1;
            } else {
                positive++;
                return 1;
            }
        }
    }
}