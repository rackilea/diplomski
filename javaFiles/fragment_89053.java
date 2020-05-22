import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int t[][] = new int[5][5];
        int n[] = new int[5];
        int x[] = new int[5];
        Random r = new Random();
        int min;
        int max;

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = r.nextInt(10) - 5;
                System.out.printf("%4d", t[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < t.length; i++) {
            min = t[0][i];
            max = t[0][i];
            for (int j = 0; j < t[i].length; j++) {
                if (t[j][i] < min) {
                    min = t[j][i];
                }
                if (t[j][i] > max) {
                    max = t[j][i];
                }
            }
            n[i] = min;
            x[i] = max;
        }

        for (int p = 0; p < x.length; p++) {
            System.out.println("Max Column " + p + ": " + x[p]);
        }

        for (int k = 0; k < n.length; k++) {
            System.out.println("Min Column " + k + ": " + n[k]);
        }
    }
}