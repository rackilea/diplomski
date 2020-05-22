rs = impl.showOnlyColumn(query);;
ResultSetMetaData metaData = rs.getMetaData();

int colProduct = 0;
int colStatus = 0;

String dataStat="";
Map<String, List<String>> mapinData= new HashMap<>();
//making column name on excel
int columnCount = metaData.getColumnCount();
for (int column = 1; column <= columnCount; column++) {
    label = new Label(column - 1, 2, metaData.getColumnName(column));
    excelSheet.addCell(label);

    // check if column is product or status 
    String columnName = metaData.getColumnName(column).toLowerCase();
    if (columnName.contains("produ")) {
        colProduct = column;
    } else if (columnName.contains("status")) {
        colStatus = column;
    }
}
//render the data
int r = 3;
while (rs.next()) {
    List<String> dataProdList = new ArrayList<>();
    for (int column = 0; column <= columnCount - 1; column++) {
        String cellValue = (rs.getString(column + 1) == null ? "" : rs.getString(column + 1));
        label = new Label(column, r, cellValue);
        excelSheet.addCell(label);
        if (column == colProduct) {
            dataProdList.add(cellValue);
        } else if (column == colStatus) {
            dataStat = cellValue;
        }
    }
    dataProdList.addAll(mapinData.getOrDefault(dataSet, new ArrayList<>()));
    mapinData.put(dataStat, dataProdList);
    r++;
}

myFirstWbook.write();