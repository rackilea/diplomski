public static void main(String[] args) {
    int[][] array = { { 1,5,9,13 }, { 2,6,10,14 }, { 3,7,11,15 },
            { 4,8,12,16 }, };

    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {

            System.out.printf("%2d ", array[i][j]);
        }
        System.out.println();
    }
}