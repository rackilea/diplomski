class MatrixButton extends JButton {
    private static final long serialVersionUID = -8557137756382038055L;
    private final int row;
    private final int col;

    public MatrixButton(String t, int col, int row) {
    super(t);
    this.row = row;
    this.col = col;
    }

    public int getRow() {
    return row;
    }

    public int getCol() {
    return col;
    }
}