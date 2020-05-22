public boolean isCompleteRow(RowSetMetaData RowSetMD) throws SQLException {
    for (int i = 0; i < cols; i++) {
        if (colsInserted.get(i) == false &&
                RowSetMD.isNullable(i + 1) == ResultSetMetaData.columnNoNulls) {
            return false;
        }
    }
    return true;
}