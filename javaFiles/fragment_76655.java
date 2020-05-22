import java.util.Arrays;

public class ArrayCopy {

    public static void main(String[] args) {

        // set up an empty source array
        char[][] src = new char[5][3];

        // fill it with random digits
        for(int i = 0 ; i < src.length; i++) {
            for(int j = 0 ; j < src[0].length; j++) {
                src[i][j] = (char) (Math.random() * 10 + 48);
            }
        }

        // show what it looks like
        printArray(src);

        // create an empty destination array with the same dimensions
        char[][] dest = new char[src.length][src[0].length];

        // walk over array and copy subarrays using arraycopy
        for (int i = 0; i < src.length; i++) {
            System.arraycopy(src[i], 0, dest[i], 0, src[0].length);
        }

        // make a change to the copy
        dest[0][0] = 'X';

        // the source array is still the same
        printArray(src);

        // hey presto!
        printArray(dest);
    }

    private static void printArray(char[][] array) {
        for(int i = 0 ; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println();
    }
}