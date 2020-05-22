if (r == 0 || r == m[0].length - 1) {
    // top or bottom row
    if (c == 0 || c == m.length - 1) {
        // top or bottom row and leftmost column or rightmost column
        System.out.print("-");
    } else {
        // top or bottom row and not leftmost column or rightmost column
        System.out.print("b");
    }
} else {
    // not top or bottom row
    if (c == 0 || c == m.length - 1) {
        // not top or bottom row and leftmost column or rightmost column
        System.out.print("w");
    } else {
        // not top or bottom row and not leftmost column or rightmost column
        System.out.print("-");
    }
}