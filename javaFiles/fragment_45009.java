public static void main(String[] args) throws FileNotFoundException {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter name of file: ");
    String filename = keyboard.next();

    Matrices matrixReader = new Matrices(filename);
    int[][] a = matrixReader.readMatrix();
    int[][] b = matrixReader.readMatrix();

    Matrices.printMatrix(a);
    System.out.println();
    Matrices.printMatrix(b);
}