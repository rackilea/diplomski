public class PrimeNumberCounter {

    public static void main(String[] args) {
        // Define integers
        int a = 1;
        final int b = 2;
        final int c = 3;
        //int d = 0; // not used
        // Define Array assuming that its size is fixed to 100
        int[] nth = new int[100];
        // Set the assignment loop
        for (a = 1; a <= nth.length; ++a) {
            // array indexing starts at 0
            nth[a - 1] = a * b + c;
        }
        // print loop
        for (int i = 0; i < nth.length; ++i) {
            System.out.printf("%d: %d\n", i + 1, nth[i]);
        }
    }
}