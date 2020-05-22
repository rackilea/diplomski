class Cell {
    private int row;

    private int column;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean is(int r, int c) {
        return row == r && column == c;
    }
}

class CellSelectionSet {
    private ArrayList<Cell> cells = new ArrayList<TestTimeTable.Cell>();

    public void add(int r, int c) {
        if (!contains(r, c)) {
            cells.add(new Cell(r, c));
        }
    }

    public boolean containsOneOrLess() {
        return cells.size() <= 1;
    }

    public boolean contains(int r, int c) {
        for (Cell cell : cells) {
            if (cell.is(r, c)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        cells.clear();
    }


}