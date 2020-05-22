public static void trianglePatterns(final int limit) {
    // Triangle One
    for (int x = 1; x <= limit; x++) {
        for (int y = 1; y <= x; y++) {
            System.out.print(y + " ");
        }
        System.out.println();
    }
    System.out.println();

    // Triangle Two
    for (int x = limit; x > 0; x--) {
        for (int y = 1; y <= x; y++) {
            System.out.print(y + " ");
        }
        System.out.println();
    }
    System.out.println();

    // Triangle Three
    // first printint spaces of each row and then the numbers
    for (int x = 1; x <= limit; x++) {
        for (int space = (limit - x); space > 0; space--) {
            System.out.print("  ");
        }

        for (int num = x; num > 0; num--) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    System.out.println();
    // Triangle Four
    for (int x = limit; x >= 0; x--) {
        for (int space = (limit - x); space > 0; space--) {
            System.out.print("  ");
        }

        for (int num = 1; num <= x; num++) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}