class JTableColumnHeaderToolTips extends MouseMotionAdapter {
    TableColumn curCol;
    // Create a Map to hold the Header Column 
    // index value and the tooltip related to 
    // it.
    Map headerColumnTips = new HashMap();

    // Method to Set tips into Map.
    public void setHeaderColumnToolTip(TableColumn column, String tooltip) {
        if (tooltip == null) {
            headerColumnTips.remove(column);
        } 
        else {
            headerColumnTips.put(column, tooltip);
        }
    }

    // Override the Header's mouseMoved event so as 
    // to display the appropriate tooltip for whatever
    // column the mouse pointer is currently on.
    @Override
    public void mouseMoved(MouseEvent event) {
        JTableHeader header = (JTableHeader) event.getSource();
        JTable table = header.getTable();
        TableColumnModel colModel = table.getColumnModel();
        int colIndex = colModel.getColumnIndexAtX(event.getX());
        TableColumn column = null;
        if (colIndex >= 0) {
            column = colModel.getColumn(colIndex);
        }
        if (column != curCol) {
            header.setToolTipText((String) headerColumnTips.get(column));
            curCol = column;
        }
    }
}