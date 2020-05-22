public int findMin() {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
           int value = grid[i][j];
           if (value < min) {
               min = value;
           }
        }
     }
     return min;
 }