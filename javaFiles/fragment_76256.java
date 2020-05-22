int size = 7;
for (int row = 0; row < size; row++) {
    for (int column = 0; column <= Math.min(size-1-row, row); column++) {
        System.out.print("*");
    }
    System.out.println();
}