public void iterateRows(List<Row> rows) {
    int cols = 5;
    int row = 0, col = 0;
    tableArray = new String[rows.size()][cols];
    for(Row row : rows) {
        col = 0;
        for(String c : row.rowString()) {
            tableArray[row][col] = c;
            col++;
        }
        row++:
    }
}