int[][] triangle = {
            { 1, },
            { 2, 3, },
            { 4, 5, 6, },
    };
    for (int[] row : triangle) {
        for (int num : row) {
            System.out.print(num + " ");
        }
        System.out.println();
    }