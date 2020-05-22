for (int row = 1; row <= 10; row++) {
    for (int j = 1; j <= row; j++) {
        System.out.print(j + " ");
    }
    System.out.print("  ");
    for (int j = 10; j >= row; j--) {
        System.out.print(j + " ");
    }
    System.out.println();
}