String[] columnNames = {"Name",
    "Size",
    "Directory",
    "Last Modified Time",
    "Readable"};
DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//...
Object[] row={"col1","col2","col3","col4","col5"};
model.addRow(row);