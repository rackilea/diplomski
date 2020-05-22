for (int i = 0; i < num; ++i) {
        for (int j = 0; j < num; ++j) {
            if (i == 0) {
                System.out.print((j + 1) + " ");
            } else if (i == num-1) {
                System.out.print((num - j) + " ");
            } else if (j == 0) {
                System.out.print((i + 1) + " ");
            } else if (j == num-1) {
                System.out.print((num - i) + " ");
            } else {
                System.out.print("  ");
            }
        }
        System.out.println();
    }