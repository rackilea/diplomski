@Override
public void actionPerformed(ActionEvent e) {
    int row = table.getSelectedRow();
    int col = table.getSelectedColumn();
    table.editCellAt(row, col);
    JTextField field = (JTextField) ((DefaultCellEditor) table
            .getCellEditor()).getComponent();
    field.requestFocus();
    field.setSelectionStart(0);
    int endSelection = 
              (!field.getText().isEmpty()) ? field.getText().length() -1 : 0;
    field.setSelectionEnd(endSelection);
}