public class Matrix extends JPanel {

    private Cell[][] matrix;

    public Matrix(int row , int col) {
        this.setLayout(new GridLayout(row, col));
        this.matrix = new Cell[row][col];
        for(int i=0; i< row ; i++) {
            for(int j=0; j<col; j++) {
                this.matrix[i][j] = new Cell();
            }
        }
    }

    public Cell getCell(int i, int j) {
        return matrix[i][j];
    }
}