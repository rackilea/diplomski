for(int row = 1; row <= n; row++){
    for(int col = row; col <= (row + n - 1); col++){
        System.out.printf("%d ", col);
    }
    System.out.println();
}