table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    public void valueChanged(ListSelectionEvent e) {
        int row = table.getSelectedRow();
        if (row != -1) {
            int modelRow = table.convertRowIndexToModel(row);
            Vector data = (Vector)((DefaultTableModel) table.getModel()).getDataVector().get(modelRow);
        }
    }
});