public class Rand {
    public static void main(String[] args) {
        int count = 8;
        int sum = 100;
        java.util.Random g = new java.util.Random();

        int vals[] = new int[count];
        sum -= count;

        for (int i = 0; i < count-1; ++i) {
            vals[i] = g.nextInt(sum);
        }
        vals[count-1] = sum;

        java.util.Arrays.sort(vals);
        for (int i = count-1; i > 0; --i) {
            vals[i] -= vals[i-1];
        }
        for (int i = 0; i < count; ++i) { ++vals[i]; }

        for (int i = 0; i < count; ++i) {
            System.out.printf("%4d", vals[i]);
        }
        System.out.printf("\n");
    }
}