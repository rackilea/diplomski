// Sort array by arrival times
int[] temp = new int[atst.length]; //to avoid any out of bound.
for (int i = 0; i < atst.length-1; i++) { //-1 will solve
    if (atst[i][1] > atst[i + 1][1]) {     // Then swap!
        temp[i] = atst[i][1];
        atst[i][1] = atst[i + 1][1];
        atst[i + 1][1] = temp[i];
    }
}