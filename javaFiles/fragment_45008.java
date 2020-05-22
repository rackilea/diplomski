class Matrices {
private Scanner fileReader;
private int rows;
private int columns;

public Matrices(String file) throws FileNotFoundException {
    this.fileReader = new Scanner(new FileInputStream(file));
    rows = fileReader.nextInt();
    columns = fileReader.nextInt();
}

public int[][] readMatrix() throws FileNotFoundException {

    int[][] result = new int[rows][columns];

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            result[i][j] = fileReader.nextInt();

        }
    }
    return result;
}

public static void printMatrix(int[][] matrix) {
    for ( int[] anArray : matrix ) {
        for ( int anInt : anArray ) {
            System.out.print(anInt+ " ");
        }
        System.out.println();
    }
}
}