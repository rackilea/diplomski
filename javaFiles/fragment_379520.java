public static void sumLeft(int[][] numbers) {
    for (int i = 0; i < numbers.length; i++) {
        for (int j = 1; j < numbers[i].length; j++) {
            numbers[i][0] += numbers[i][j];
            numbers[i][j] = 0;
        }
    }
}