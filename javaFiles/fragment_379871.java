public static void main(String[] args) {
    int[][] arr = { { 0, 1, 0, 2 }, // turns into {1,2,0,0}
            { 2, 1, 0, 2 }, // turns into {2,1,2,0}
            { 1, 1, 0, 0 }, // turns into {2,0,0,0}
            { 0, 2, 0, 2 }, // turns into {4,0,0,0}
            { 1, 1, 3, 3 }, // turns into {2,6,0,0}
            { 2, 2, 2, 2 } };// turns into {4,4,0,0}
    for (int[] a : arr) {
        combine(a);
        System.out.println(Arrays.toString(a));
    }
}