private JTable createTable(ResultSet rs) {
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    JTable table = new JTable(model);

    table.setEnabled(false);
    JTableHeader header1 = table.getTableHeader();
    header1.setResizingAllowed(false);
    header1.setReorderingAllowed(false);
    header1.setForeground(Color.white);
    header1.setBackground(Color.black);

    while(rs.next()){
        Vector<Object> rowVector = new Vector<Object>();
        for(int i=1;i<=columnCount;i++){
            rowVector.add(rs.getString(i));

        }
        model.addRow(rowVector);
    }

    return table;
}