public class StackOverflow {
    public static void main(String[] args) {
        int[][] a0 = null;
        int[][] b0 = null;
        int[][] a1 = {};
        int[][] b1 = {};
        System.out.println(ex1(a0, b0) == false);
        System.out.println(ex1(a0, b1) == false);
        System.out.println(ex1(a1, b0) == false);
        System.out.println(ex1(a1, b1) == false);
        int[][] a2 = { { 2, 1, 5 }, { 3, 10, 6 }, { 4, 100, 7 } };
        int[][] b2 = { { 4, 7, 1 }, { 3, 5, 10 }, { 2, 6, 100 } };
        System.out.println(ex1(a2, b2) == true);
        int[][] a3 = { { 2, 1, 5 }, { 3, 10, 6 }, { 4, 100, 7 } };
        int[][] b3 = { { 4, 1, 7 }, { 3, 10, 6 }, { 2, 0, 5 } };
        System.out.println(ex1(a3, b3) == false);
        int[][] a4 = { { 2, 1, 5 }, { 3, 10, 6 }, { 4, 100, 7 } };
        int[][] b4 = { { 1, 4, 7 }, { 10, 3, 6 }, { 0, 2, 5 } };
        System.out.println(ex1(a4, b4) == false);
        int[][] a5 = { { 1, 2, 5 }, { 10, 3, 6 }, { 100, 4, 7 } };
        int[][] b5 = { { 1, 4, 1 }, { 10, 3, 10 }, { 0, 2, 100 } };
        System.out.println(ex1(a5, b5) == true);
        int[][] a6 = { { 1, 2, 5 }, { 10, 3, 6 }, { 100, 4, 7 } };
        int[][] b6 = { { 1, 1, 7 }, { 1, 10, 6 }, { 0, 100, 5 } };
        System.out.println(ex1(a6, b6) == true);
    }

    public static boolean ex1(int[][] a, int[][] b) {
        if (a == null || a.length < 1 || b == null || b.length < 1) {
            return false;
        }

        // Check that both arrays have the same number of rows
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            // Check that each row has the same number of columns
            if (a[i].length != b[i].length) {
                return false;
            }

            // Check the contents of each row
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}