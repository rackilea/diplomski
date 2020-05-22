import java.util.Arrays;

public class Temp {
    public static void main(String[] args) {
        int[][] jagged = {{1, 2, 3}, {4, 5, 6, 7, 8}, {9, 10, 11, 12, 13, 14, 15, 16}};
        System.out.println("Jagged: " + Arrays.deepToString(jagged));
        System.out.println("Smaller 1: " + Arrays.deepToString(removeRowAndCol(jagged, 0, 0)));
        System.out.println("Smaller 2: " + Arrays.deepToString(removeRowAndCol(jagged, 1, 1)));
        System.out.println("Smaller 3: " + Arrays.deepToString(removeRowAndCol(jagged, 2, 2)));
    }

    private static int[][] removeRowAndCol(int[][] jagged, int i, int j) {
        int[][] smaller = new int[jagged.length - 1][];

        // WARN: outofbounds checks are not implemented!
        for (int smallerI = 0; smallerI < smaller.length; smallerI++) {
            int sourcedI = smallerI;
            if (smallerI >= i) {
                sourcedI++;
            }

            smaller[smallerI] = new int[jagged[sourcedI].length - 1];

            for (int smallerJ = 0; smallerJ < smaller[smallerI].length; smallerJ++) {
                int sourcedJ = smallerJ;
                if (smallerJ >= j) {
                    sourcedJ++;
                }
                smaller[smallerI][smallerJ] = jagged[sourcedI][sourcedJ];
            }
        }

        return smaller;
    }
}