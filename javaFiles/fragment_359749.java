int[][] tests = {
            {2, 4},
            {3, 9},
            {10, 100}
    };
    for (int[] test : tests) {
        assertEquals(test[1], f(test[0]));
    }