import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args) {
        int[] x = {12, 8, 6, 23, 6, 5, 17, 20, 9};
//      Arrays.sort(x);
        int y = linearSearch(x, 23);
        System.out.println("" + y);
//      int z = Arrays.binarySearch(x, 23);
//      System.out.println("" + z);
    }

    public static int linearSearch(int[] ar, int value) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == value) {
                return i;
            }
        }
        return -1;
    }

}