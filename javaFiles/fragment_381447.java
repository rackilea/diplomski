public class Test {
    private static int[][] temp = new int[][] {{0,2, 4},{4, 4,16}, {3, 0, 128}};

    public static void main(String[] args) {
        int rows = temp.length;
        int cols = temp[0].length;

        for (int i = 0; i < rows; i++) {
            // This will resize our row separator for each row
            for (int j = 0; j < cols; j++) {
                System.out.print("+-----");
            }

            System.out.print("+\n");

            for (int j = 0; j < cols; j++) {
                System.out.print("|");

                // Here you have to deal with the spacing. You can see that this is ugly.
                // There's definitely better ways to do this, such as using mod
                if (temp[i][j] == 0) {System.out.print("     ");}
                else if (temp[i][j] < 10) {System.out.print("  " + temp[i][j] + "  ");}
                else if (temp[i][j] < 100) {System.out.print("  " + temp[i][j] + " ");}
                else if (temp[i][j] < 1000) {System.out.print(" " + temp[i][j] + " ");}
            }

            System.out.print("|\n");
        }

        for (int j = 0; j < cols; j++) {
            System.out.print("+-----");
        }

        System.out.print("+\n");
    }
}