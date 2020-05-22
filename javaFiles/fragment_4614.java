static void printDay(int[][] regions, int n) {
    System.out.printf("day %d:%n", n);
    for (int i = 0; i < regions.length; i++) {
        for (int j = 0; j < regions[i].length; j++) {
            System.out.printf("%3d ", regions[i][j]);
        }
        System.out.println();
    }
}