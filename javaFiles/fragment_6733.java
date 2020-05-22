public static void columnAverage(int array[][]) {
    for (int col = 0; col < array[col].length; col++) {
        int sum = 0;
        for (int row = 0; row < array.length; row++) {
            sum += array[row][col];

        }
        System.out.println(sum / array.length);
        System.out.println();
    }
}