public class Perm {
    private static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    private static void swap(int[] elements, int i, int j) {
        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    /**
     * Reverses the elements of an array (in place) from the start index to the end index 
     */
    private static void reverse(int[] array, int startIndex, int endIndex) {
        int size = endIndex + 1 - startIndex;
        int limit = startIndex + size / 2;
        for (int i = startIndex; i < limit; i++) {
            // swap(array, i, startIndex + (size - 1 - (i - startIndex)));
            swap(array, i, 2 * startIndex + size - 1 - i);
        }
    }

    private static void printSequence(int[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            System.out.printf("%d, ", sequence[i]);
        }
        System.out.println();
    }

    /**
     * Implements the Knuth's L-Algorithm permutation algorithm 
     * modifying the collection in place
     */
    private static void permutations(int[] sequence) {
        final int N = sequence.length;
        // There are n! permutations, but the first permutation is the array without 
        // modifications, so the number of permutations is n! - 1
        int numPermutations = factorial(N) - 1;

        // For every possible permutation 
        for (int n = 0; n < numPermutations; n++) {

            // Iterate the array from right to left in search 
            // of the first couple of elements that are in ascending order
            for (int i = N - 1; i >= 1; i--) {
                // If the elements i and i - 1 are in ascending order
                if (sequence[i - 1] < sequence[i]) {
                    // Then the index "i - 1" becomes our pivot index 
                    int pivotIndex = i - 1;

                    // Scan the elements at the right of the pivot (again, from right to left)
                    // in search of the first element that is bigger
                    // than the pivot and, if found, swap it
                    for (int j = N - 1; j > pivotIndex; j--) {
                        if (sequence[j] > sequence[pivotIndex]) {
                            swap(sequence, j, pivotIndex);
                            break;
                        }
                    }

                    // Now reverse the elements from the right of the pivot index
                    // (this nice touch to the algorithm avoids the recursion)
                    reverse(sequence, pivotIndex + 1, N - 1);
                    break;
                }
            }

            printSequence(sequence);
        }
    }

    public static void main(String... args) {
        final int N = 3;
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = i + 1;
        }

        printSequence(sequence);
        permutations(sequence);
    }
}