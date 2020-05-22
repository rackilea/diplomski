public static void im(int[][] m, int r, int c) {
    if (r == 0 || r == m.length - 1) {
        // top or bottom row
        if (c == 0 || c == m[0].length - 1) {
            // top or bottom row and leftmost column or rightmost column
            System.out.print("-");
        } else {
            // top or bottom row and not leftmost column or rightmost column
            System.out.print("b");
        }
    } else {
        // not top or bottom row
        if (c == 0 || c == m[0].length - 1) {
            // not top or bottom row and leftmost column or rightmost column
            System.out.print("w");
        } else {
            // not top or bottom row and not leftmost column or rightmost column
            System.out.print("-");
        }
    }
    if (c == m[0].length - 1) {
        // rightmost column
        System.out.println();
        if (r != m.length - 1) {
            // not bottom row
            im(m, r + 1, 0);
        }
    } else {
        // not rightmost column
        im(m, r, c + 1);
    }
}