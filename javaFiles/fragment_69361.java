import java.util.Arrays;

public class Abc {
    static final int[] gaps(int n) {
        final int[] untrimmedResult = new int[15];
        int i = 0;

        // Remove trailing zeroes and last one bit to get to first gap.
        n >>>= Integer.numberOfTrailingZeros(n) + 1;
        while (n != 0) {
            final int gapSize = Integer.numberOfTrailingZeros(n);
            untrimmedResult[i++] = gapSize;
            n >>>= gapSize + 1;
        }

        final int[] result = new int[i];
        System.arraycopy(untrimmedResult, 0, result, 0, i);
        return result;
    }

    // driver program 
    public static void main(final String[] args) {
        final int n = 1041;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Arrays.toString(gaps(n)));
    }
}