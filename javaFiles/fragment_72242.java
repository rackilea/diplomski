class CellGrid implements Grid {
    private Cell[][] cells;

    public CellGrid(int rows, int cols){
        cells = new Cell[rows][cols];
        // initialize
    }

    // get a value using the implementation we chose
    public String getValue(int row, int col) {
        return cells[row][col].getValue();
    }
}