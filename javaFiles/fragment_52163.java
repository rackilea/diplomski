int boxSums[][] = new int[3][3];
for (int iStart = 0; iStart < 9; iStart += 3) {
    for (int jStart = 0; jStart < 9; jStart += 3) {
        int sum = 0;
        for (int i = iStart; i < iStart + 3; i++) {
            for (int j = jStart; j < jStart + 3; j++) {
                sum += grid[i][j];
            }
         }
         boxSums[iStart / 3][jStart / 3] = sum;
     }
}