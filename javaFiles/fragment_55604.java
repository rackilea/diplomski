class Matrix2D {
    private int[] ordering;
    private MatrixRow[] rows;

    public double getValue(int row, int col) {
        return rows[ordering[row]].get(col);
    }
    ...
}