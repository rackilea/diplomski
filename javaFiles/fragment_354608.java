import java.util.List;
import java.util.ArrayList;

public class PrimeNumberCounter {

    public static void main(String[] args) {
        // Define integers
        int a = 1;
        final int b = 2;
        final int c = 3;
        // Some size N let's assume it's a 100 again
        List<Integer> nth = new ArrayList<Integer>();
        // Set the assignment loop
        for (a = 1; a <= 100; ++a) {
            // array indexing starts at 0
            nth.add(a - 1, a * b + c);
        }
        // print loop
        for (int i = 0; i < nth.size(); ++i) {
            System.out.printf("%d: %d\n", i + 1, nth.get[i]);
        }
    }
}