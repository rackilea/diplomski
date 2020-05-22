int colCount = 1 + queryResult.size();

String[] row = new String[colCount];
row[0] = t.getDate();

for(int i = 1; i < row.length; i++) {
    row[i] = "some data"; // or get data from somewhere else
}

tableModel.addRow(row);