public class ThreeDotTwelvea {

    final static int NO_OF_ROWS = 10;

    public static void main(String[] args) {

        for (int i = 0; i < NO_OF_ROWS; i++) {
            for (int j = NO_OF_ROWS - i - 1; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}