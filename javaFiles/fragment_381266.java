public static void main(String[] args) {
    int[][][] testCases = { { { 11, 19 }, { 19 } }, //
            { { 19, 11 }, { 19 } }, //
            { { 11, 9 }, { 11 } }, //
            { { 9, 21 }, { 0 } }, //
            { { 10, 21 }, { 10 } }, //
            { { 21, 10 }, { 10 } }, //
            { { 9, 11 }, { 11 } }, //
            { { 23, 10 }, { 10 } }, //
            { { 20, 10 }, { 20 } }, //
            { { 7, 20 }, { 20 } }, //
            { { 17, 16 }, { 17 } } };
    for (int i = 0; i < testCases.length; i++) {
        int a = testCases[i][0][0], b = testCases[i][0][1], c = testCases[i][1][0];
        int r = max1020(a, b);
        System.out.printf("max1020(%d, %d) -> %d   %d %s%n", a, b, r, c, 
                c == r ? "OK" : "X");
    }
}