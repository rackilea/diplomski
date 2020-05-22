public static void printRow(int[] row) {
    for (int i : row) {
        String str = null;
        if (i == 0) str = "  "; // 0 = don't show
        else if (i < 10) str = " " + i; // 1 digit
        else str = "" + i; // 2 digits
        System.out.print(str + " ");
        System.out.print(" ");
    }
    System.out.println();
}