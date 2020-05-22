public static void main(String args[]) {
    final int REGION_SIZE = 20;

    int[][] regions = new int[REGION_SIZE][REGION_SIZE];

    for (int n = 0; n < 1000; n++) {
        for (int i = 0; i < REGION_SIZE; i++) {
            for (int j = 0; j < REGION_SIZE; j++) {
                calculateRegion(regions, i, j);
            }
        }
        printDay(regions, n);
    }
}