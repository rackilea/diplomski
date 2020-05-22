int[][] temp = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
    int[][] a = new int[temp.length][];
    for (int i = 0; i < temp.length; i++) {
        a[i] = Arrays.copyOfRange(temp[i], 1, 3);
    }
    System.out.println(Arrays.deepToString(a));