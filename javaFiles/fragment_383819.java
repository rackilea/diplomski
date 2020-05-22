String[][] seatingChart = new String[rows][columns];
    for(int i = 0; i < rows; i++) {
        for(int j = 0; j < columns; j++) {
            seatingChart[i][j] = "" + ((char)('A' + i)) + ((char)('1' + j));
        }
    }