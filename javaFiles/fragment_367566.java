JTable table = new JTable(writeResult(res));


public static DefaultTableModel writeResult (ResultSet res) throws SQLException {

    ResultSetMetaData metaData = res.getMetaData();

    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (res.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(res.getObject(columnIndex));
        }
        data.add(vector);
    }
    return new DefaultTableModel(data, columnNames);
}