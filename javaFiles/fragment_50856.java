Object[][] data = new Object[rowCount][colCount];
    int row = 0;
    while (rs.next()) {
        for (int i = 0; i < colCount; i++) {
            data[row][i] = rs.getObject(i+1);
        }
        row++;
    }
    return data;