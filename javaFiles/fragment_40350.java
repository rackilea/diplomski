String text = "01234567890123456789";
    int[][][] tests = {
        { { 0, 5, },
        }, // simple test, removing prefix
        { { 1, 2, }, { 3, 4, }, { 5, 6, }
        }, // multiple infix removals
        { { 3, 7, }, { 18, 20, },
        }, // suffix removal
        {
        }, // no-op
        { { 0, 20 },
        }, // remove whole thing
        { { 7, 10 }, { 10, 13 }, {15, 15 }, 
        }, // adjacent intervals, empty intervals
    };

    for (int[][] test : tests) {
        StringBuffer sb = new StringBuffer(text);
        System.out.printf("> '%s'%n", sb);
        System.out.printf("- %s%n", java.util.Arrays.deepToString(test));
        removeIntervals(sb, test);
        System.out.printf("= '%s'%n%n", sb);
    }