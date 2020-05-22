public int[] locateZero(int[][] array) {
    int[] coordinates = new int[2];
    for (int i=0; i < array.length; i++) {
        for (int j=0; j < array[0].length; j++) {
            if (array[i][j] == 0) {
                //here is the difference
                coordinates[0] = i;
                coordinates[1] = j;
            }
        }
    }
    return coordinates;
}