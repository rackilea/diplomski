int[][] a = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
    int[][] ar = new int[a.length][];
    int len, index;
    for (int i=0; i < a.length; i++) {
        len = a[i].length;
        ar[i] = new int[len];
        index = len-1;
        for (int j=0; j < len; j++) {
            ar[i][j] = a[i][index];
            index--;
        }
    }
    System.out.println(Arrays.deepToString(a));
    System.out.println(Arrays.deepToString(ar));