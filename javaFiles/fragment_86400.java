for (int row = 0; row < ROWS; row++) {
    System.out.printf("%5d\n", MPH[row]);
}
for (int row = 0; row < ROWS; row++) {
    for (int col = 0; col < COLS; col++) {
        System.out.printf("%13.2f", trajectories[row][col]);
    }
    System.out.println();
}