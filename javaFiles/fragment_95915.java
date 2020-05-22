public void addRow(Object[] rowData) {
    Object[][] newData;
    int maxCol;
    if ((data != null) && (data.length > 0)) {
        newData = new Object[data.length + 1][data[0].length];
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[0].length; col++) {
                newData[row][col] = data[row][col];
            }
        }
        maxCol = data[0].length < rowData.length ? data[0].length : rowData.length;
    } else {
        newData = new Object[1][rowData.length];
        maxCol = rowData.length;
    }
    //Insert rowData objects
    for (int col = 0; col < maxCol; col++) {
        newData[newData.length - 1][col] = rowData[col];
    }
    data = newData;
    fireTableRowsInserted(data.length - 1, data.length - 1);
}