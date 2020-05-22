import java.util.Arrays;

public class Main {
    public static void swap(final Object[] array, final int index1, final int index2) {
        final Object tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static void printPermutations_HeapsAlgorithm(final int n, final Object[] array) {
        final int[] c = new int[n];

        for (int i = 0; i < c.length; ++i)
            c[i] = 0;

        System.out.println(Arrays.toString(array)); //Consume first permutation.

        int i=0;

        while (i < n) {
            if (c[i] < i) {
                if ((i & 1) == 0)
                    swap(array, 0, i);
                else
                    swap(array, c[i], i);

                System.out.println(Arrays.toString(array)); //Consume permutation.

                ++c[i];
                i=0;
            }
            else
                c[i++] = 0;
        }
    }

    public static void main(final String[] args) {
        printPermutations_HeapsAlgorithm(4, new Character[]{'A', 'B', 'C', 'D'});
    }
}