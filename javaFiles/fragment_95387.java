public static void printChar(int n, char c) {
    // print the upper triangle
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < i + 1; ++j) {
            System.out.print(c);
        }
        System.out.println();
    }

    // print the lower triangle
    for (int i = n - 1; i > 0; --i) {
        for (int j = 0; j < i; ++j) {
            System.out.print(c);
        }
        System.out.println();
    }
}