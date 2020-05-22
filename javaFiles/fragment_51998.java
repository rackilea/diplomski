public class IncExc {
    public static void main(String[] args) {
        int a[] = {3, 5, 7};
        int m = 500;
        System.out.println(count(a, m));
    }

    static int count(int a[], int m) {
        int odd = 0;
        int even = 0;
        int powSetSize = 1 << a.length;

        // For all sub-sets of elements in the array of primes
        for (int counter = 1; counter < powSetSize; counter++) {
            int p = 1;
            for (int j = 0; j < a.length; j++) {
                // If the jth bit of this combination is set then multiply in the jth element
                if ((counter & (1 << j)) != 0) {
                    p *= a[j];
                }
            }

            // If the number of factors in p is odd, accumulate the count of multiples in our "odd" register
            // Otherwise use the "even" register
            if ((Integer.bitCount(counter) & 1) == 1)
                odd += m / p;
            else
                even += m / p;
        }

        return odd - even;
    }
}