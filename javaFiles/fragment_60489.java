import java.util.Arrays;

public class Test { 

    public static void main(String[] args) {
        int[] x = { 1, 2, 3, 4, 5 };
        int[] y = { 15, 60, 23, 10, 100 };

        swapValues(x, y);
        System.out.println("x: " + Arrays.toString(x));
        System.out.println("y: " + Arrays.toString(y));
    }

    static void swapValues(int[] a, int[] b) {
        // TODO: Validation
        for (int i = 0; i < a.length; i++) {
            a[i] += b[i];
            b[i] = a[i] - b[i];
            a[i] -= b[i];
        }
    }
}