int[] arr1d = new int[9];
int[][] arr2d = {
    { 1, 2, 3 },
    { 4, 5, 6 },
    { 7, 8, 9 },
};
for (int r = 0, i = 0; r < 3; r++) {
    for (int c = 0; c < 3; c++) {
        arr1d[i++] = arr2d[r][c];
    }
}
System.out.println(Arrays.toString(arr1d));
// prints "[1, 2, 3, 4, 5, 6, 7, 8, 9]"