for (int row = 1; row <= size; row++) {
    for (int column = 1; column <= size-row; column++) {
        System.out.print(" ");
    }
    for (int column = 1; column <= row; column++) {
        System.out.print("*");
    }
    System.out.println();
}