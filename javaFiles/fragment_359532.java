for (int j = 0; j < _j; j++) {
    if (i == 0 || j == 0 || i == _i - 1 || j == _j - 1) {
        array[i][j] = "*";
    } else {
        array[i][j] = " ";
    }
    System.out.print(array[i][j]);
}
System.out.println();