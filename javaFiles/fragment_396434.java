class Matrix {
    private Vector[] rows;

    Matrix(Vector... value) {
        this.rows = value;
    }

    int apply(int x, int y) {
        return rows[x - 1].apply(y);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String prefix = "";
        for (Vector row : rows) {
            result.append(prefix).append(row.toString());
            prefix = System.lineSeparator();
        }
        return result.toString();
    }
}