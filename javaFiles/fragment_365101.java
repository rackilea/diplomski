// 1
    int[] x = new int[5];
    x[-1] = 0; // ArrayIndexOutOfBoundsException: -1

    // 2
    int[] x = new int[5];
    x[5] = 0; // ArrayIndexOutOfBoundsException: 5

    // 3
    int[][] table = new int[3][3];
    table[0][10] = 0; // ArrayIndexOutOfBoundsException: 10

    // 4
    int[][] table = new int[3][3];
    table[-10][10] = 0; // ArrayIndexOutOfBoundsException: -10

    // 5
    int[][][][] whoa = new int[0][0][0][0];
    whoa[0][-1][-2][-3] = 42; // ArrayIndexOutOfBoundsException: 0

    // 6
    int[][][][] whoa = new int[1][2][3][4];
    whoa[0][1][2][-1] = 42; // ArrayIndexOutOfBoundsException: -1