public class UltimateDiamondMaker {
    public static void main(String[] args) {
        print(10, "(", ")");
    }

    /*
     * This method will print the diamond
     *
     * @param iMax the half of the length of the diamond
     *
     * @param left the string to be printed on the left side of the diamond
     *
     * @param right the string to be printed on the right side of the diamond
     */
    public static void print(int iMax, String left, String right) {
        printUp(iMax, left, right);
        printDown(iMax, left, right);
    }

    /*
     * This method will print upper part the diamond
     *
     * @param iMax the half of the length of the diamond
     *
     * @param left the string to be printed on the left side of the diamond
     *
     * @param right the string to be printed on the right side of the diamond
     */
    public static void printUp(int iMax, String left, String right) {
        for (int i = 0; i < iMax; i++) {
            printHelper(0, iMax - i, " ");
            printHelper(iMax - i, iMax, left);
            printHelper(iMax - i, iMax, right);
            System.out.println();
        }
    }

    /*
     * This method will print lower part the diamond
     *
     * @param iMax the half of the length of the diamond
     *
     * @param left the string to be printed on the left side of the diamond
     *
     * @param right the string to be printed on the right side of the diamond
     */
    public static void printDown(int iMax, String left, String right) {
        for (int i = 0; i < iMax; i++) {
            printHelper(iMax - (i + 1), iMax, " ");
            printHelper(1, iMax - i, left);
            printHelper(1, iMax - i, right);
            System.out.println();
        }
    }

    /*
     * This method is a helper method. This will print a single line in the diamond
     *
     * @param start the start index
     *
     * @param end the end index
     *
     * @param s the string to be printed
     */
    public static void printHelper(int start, int end, String s) {
        for (int j = start; j <= end; j++) {
            System.out.print(s);
        }
    }
}