int columnIndex1 = 1;
    int columnIndex2 = 4;
    while(rs1.next()) {
        List<Object> row = new ArrayList<Object>();
        row.add(rs1.getString(columnIndex1)); // get one column
        row.add(rs1.getString(columnIndex2)); // get the other column
        EventAll.add(row);
    }