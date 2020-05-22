public Object getObject(String columnLabel) throws SQLException {
    return getObject(getIndexByLabel(columnLabel));
}

private int getIndexByLabel(String columnLabel) {
    Map<String, Integer> indexMap = createOrGetIndexMap();
    Integer columnIndex = indexMap.get(columnLabel.toLowerCase());
    if (columnIndex == null) {
        throw new SQLException("Column label " + columnLabel + " does not exist in the result set");
    }
    return columnIndex;
}

private Map<String, Integer> createOrGetIndexMap() throws SQLException {
    if (this.indexMap != null) {
        return this.indexMap;
    }
    ResultSetMetaData rsmd = getMetaData();
    Map<String, Integer> map = new HashMap<>(rsmd.getColumnCount());
    // reverse loop to ensure first occurrence of a column label is retained
    for (int idx = rsmd.getColumnCount(); idx > 0; idx--) {
        String label = rsmd.getColumnLabel(idx).toLowerCase();
        map.put(label, idx);
    }
    return this.indexMap = map;
}