public static void show( int n )
    {
       for (int i = 0; i < n - 1; i+=2) {
        for (int j = 0; j < i; j++) {
            System.out.print(" ");
        }
        for (int k = n - i; k > 0; k--) {
            System.out.print("* ");
        }
        System.out.println();
    }
    for (int i = 0; i <n; i+=2) {
        for (int j = n - i; j > 1; j--) {
            System.out.print(" ");
        }
        for (int k = 0; k < i + 1; k++) {
            System.out.print("* ");
        }
        System.out.println();
    }
    }