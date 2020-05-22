class MatrixModel extends AbstractTableModel {

    private int rows;
    private int cols;
    private Boolean[][] matrix;

    MatrixModel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new Boolean[rows][cols];
    }

    public void deleteColumn(int col) {
        for (Boolean[] row : matrix) {
            Boolean[] newRow = new Boolean[row.length - 1];
            // TODO: copy remaining values
            row = newRow;
        }
        this.fireTableStructureChanged();
    }
    ...
}