Sudoku s = new Sudoku("C:\\Users\\caspe\\Downloads\\Sudoku001.sdk");
s.printBoard();
s.errorCheck();
int numDots = s.getNumDots();
Scanner scanner = new Scanner(System.in);
while (numDots > 0) {
    System.out.println("Next move, please (row , column , value )");
    int row = scanner.nextInt();
    int column = scanner.nextInt() ;
    int value = scanner.nextInt();
    if (s.moves(row, column, value)) {
        numDots--;
        s.errorCheck();
        s.printBoard();
    }
}