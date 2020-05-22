for (int r = 0; r < n; r++) {
        System.out.print(r);
        for (int c = 0; c < n; c++) {
            System.out.print(r % 2 == 1 ^ c % 2 == 0 ? " *" : "  ");
        }
        System.out.println();
    }