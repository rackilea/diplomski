public int getInt(int columnIndex) throws SQLException {
    ...
}

public int getInt(String columnName) throws SQLException {
    int idx = findColumn(columnName);
    return getInt(idx);
}