int[][] uneven = 
    { { 1, 3, 100, 6, 7, 8, 9, 10},
      { 0, 2},
      { 0, 2, 4, 5},
      { 0, 2, 4, 6, 7},
      { 0, 1, 4, 5 },
      { 0, 1, 2, 3, 4, 5, 6 }};

    int max = -1;
    for ( int row = 0; row < uneven.length; row++ ) {
        if (uneven[row].length > max) {
            max = uneven[row].length;
        }
    }
    System.out.println(max);
    for (int i = 0; i < max; i++) {
        for (int j = 0; j < uneven.length; j++) {
            if (uneven[j].length <= i) {
                continue;
            }
            System.out.print(uneven[j][i] + " ");
        }
        System.out.println();
    }