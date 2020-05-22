private void SetJTableHeaderColumnToolTips(JTable table, String[] columnToolTips) {
    JTableHeader tableHeader = table.getTableHeader();

    // See the JTableColumnHeaderToolTips SubClass. 
    JTableColumnHeaderToolTips toolTips = new JTableColumnHeaderToolTips();
    for (int col = 0; col < table.getColumnCount(); col++) {
        TableColumn columnIndex = table.getColumnModel().getColumn(col);
        toolTips.setHeaderColumnToolTip(columnIndex, columnToolTips[col]);
    }
    tableHeader.addMouseMotionListener(toolTips);
}