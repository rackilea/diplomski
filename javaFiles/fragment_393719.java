public static void turnOff(int i, int j) {
    // i=0, j=3
    if (table[i][j] == 1) {
        table[i][j] = 0;

        if (j < width - 1) {
            turnOff(i, j+1);  // calls turnOff(0,4)
        }

        if (j > 0) {
            turnOff(i, j-1);  // calls turnOff(0,2)
        }

        //etc