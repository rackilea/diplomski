for (int z = n - 2; z >= 0; z--) {
        for (int i = 1; i <= n - z; i++) {
            for (int j = 1; j <= n - i; j++)
                System.out.printf("%5s", "");
            for (int k = 1; k < i; k++)
                System.out.printf("%5d", (int) Math.pow(2, k));
            for (int k = i; k >= 1; k--)
                System.out.printf("%5d", (int) Math.pow(2, k));
            System.out.println();
        }
    }