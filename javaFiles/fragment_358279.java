public static void assignSudokuBox(int rowIndex, int m, int n) {
    // index, if devided to pieces n x 1
    int nChunkIndex = rowIndex / n;

    // every row has m of those pieces and there are m rows in each box
    int row = nChunkIndex / (m*m);

    int column = nChunkIndex % m;

    int result = column + row * m;

    System.out.println("Box of index " + rowIndex + " is: " + result + ".");

}