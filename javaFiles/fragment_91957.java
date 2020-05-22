Vector data = new Vector(columnCount);
    Vector row = new Vector(columnCount);
    Vector columnNames = new Vector(columnCount);


    for (int i = 1; i <= columnCount; i++) {
        columnNames.addElement(md.getColumnName(i));
    }
    while (rs.next()) {
        for (int i = 1; i <= columnCount; i++) {
            row.addElement(rs.getObject(i));

        }
        data.addElement(row);
        row = new Vector(columnCount); // Create a new row Vector
    }
    DefaultTableModel model = new DefaultTableModel(data, columnNames);
    jTable1.setModel( model );