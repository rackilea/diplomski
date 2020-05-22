public static void updateTableModelData(DefaultTableModel tModel, ResultSet rs) 
        throws Exception {
    tModel.setRowCount(0);
    ResultSetMetaData metaData = rs.getMetaData();

    while (rs.next()) {
        Vector newRow = new Vector();
        for (int i = 1; i <= numberOfColumns; i++) {
            newRow.addElement(rs.getObject(i));
        }
        tModel.addRow(newRow);
    }
}