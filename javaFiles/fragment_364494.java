// Sort array by arrival times
int[] temp = new int[atst.length]; //to avoid any out of bound.
for (int i = 0; i < atst.length-1; i++) { //-1 will solve
    for (int j = 0; i < 2; j++) {
        if (atst[i][j] > atst[i + 1][j]) {     // Then swap!
           temp[i] = atst[i][j];
           atst[i][j] = atst[i + 1][j];
           atst[i + 1][j] = temp[i];
        }
    }
}