int array[][] = {{0, 1, 1, 1, 1, 0, 0},
                 {0, 0, 0, 1, 0, 1, 1},
                 {0, 0, 0, 1, 0, 1, 1},
                 {0, 1, 1, 0, 1, 0, 1},
                 {1, 0, 0, 1, 0, 1, 1},
                 {1, 0, 0, 1, 0, 1, 0}};

//Search rows
for (int i = 0; i < array.length; i++) {
    int rowCount = 0;                   
    for (int j = 0; j < array[i].length; j++) {
        if (array[i][j] == 0) {
            rowCount++;
        } else {
            rowCount = 0;
        }
        if (rowCount == 4) {
            System.out.println("yay");
        }
    }
}