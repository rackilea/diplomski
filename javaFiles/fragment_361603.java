public static void main(String[] args) {
    List<Integer> magicSquare = Arrays.asList(2,7,6,9,5,1,4,3,8);

    int n = (int) Math.sqrt(magicSquare.size());
    int rowSums[] = new int[n];
    int colSums[] = new int[n];
    int sumDiagMajor = 0;
    int sumDiagMinor = 0;

    int row = -1;
    int col = -1;

    for (int index = 0; index < n*n; index++) {

        col++;
        if (col % n == 0) {
            row++;
            col = 0;
        }

        rowSums[row] = rowSums[row] + magicSquare.get(index);
        colSums[col] = colSums[col] + magicSquare.get(index);


        if (row == col)
        {
            sumDiagMajor += magicSquare.get(index);
        }

        if ((row + col) == (n - 1))
        {
            sumDiagMinor += magicSquare.get(index);
        }

    }

    boolean isMagicSquare = true;
    for (int i = 0; i < n && isMagicSquare; i++) {
        isMagicSquare = sumDiagMajor == rowSums[i] && sumDiagMajor == colSums[i];
    }
    isMagicSquare = isMagicSquare && sumDiagMajor == sumDiagMinor;

    System.out.println(isMagicSquare); // true
}