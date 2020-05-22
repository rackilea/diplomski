ResultSet rs = pst.executeQuery();
ResultSetMetaData rsmd = rs.getMetaData();
int columnCount = rsmd.getColumnCount();

HSSFWorkbook wb = new HSSFWorkbook();
HSSFSheet sheet = wb.createSheet("Excel Sheet");
HSSFRow rowhead = sheet.createRow(0);

DefaultTableModel model = new DefaultTableModel();
for (int col = 0; col < columnCount; col++) {
    String columnName = rsmd.getColumnName(col + 1);
    model.addColumn(columnName);
    rowhead.createCell(col).setCellValue(columnName);
}

int index = 1;
while (rs.next()) {
    Vector tableRow = new Vector(columnCount);
    HSSFRow row = sheet.createRow(index);
    for (int col = 0; col < columnCount; col++) {
        Object value = rs.getObject(col + 1);
        if (value instanceof Integer) {
            row.createCell(col).setCellValue((int) value);
            tableRow.add((int) value);
        } else {
            row.createCell(col).setCellValue(value.toString());
            tableRow.add(value.toString());
        }
    }
    model.addRow(tableRow);
}

try (FileOutputStream fileOut = new FileOutputStream("e:/CLIENTDATA/client.xlsx")) {
    wb.write(fileOut);
}