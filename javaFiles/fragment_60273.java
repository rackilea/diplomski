class EditCellAction extends AbstractAction {
    private JTable table;

    public EditCellAction(JTable table) {
        putValue(NAME, "Edit");
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int row = table.getSelectedRow();
        int col = table.getSelectedColumn();
        String newValue = JOptionPane.showInputDialog(table,
                "Enter a new value:", table.getValueAt(row, col));
        ((DefaultTableModel) table.getModel()).setValueAt(
                                               newValue, row, col);
    }
}