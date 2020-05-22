jTable1.getModel().addTableModelListener(new TableModelListener() {
    final int YOUR_BOOLEAN_COLUMN = 1;
    public void tableChanged(TableModelEvent e) {
        if(e.getColumn() == YOUR_BOOLEAN_COLUMN) {
            // get value from model (not affected if user re-orders columns)
            TableModel tableModel = jTable1.getModel();
            Boolean value =
                (Boolean)tableModel.getValueAt(e.getFirstRow(), YOUR_BOOLEAN_COLUMN);
            System.out.println(value);
        }
    }
});