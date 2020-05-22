public static void turnOff(int i, int j) {
    // i=0, j=3
    if (table[i][j] == 1) {
        table[i][j] = 0;

        if (j < width - 1) {
            turnOff(i, j++);  // calls turnOff(0,3) and sets j=4
        }

        if (j > 0) {
            turnOff(i, j--); // calls turnOff(0,4) and sets j=3
        }

        //etc