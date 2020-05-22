@Override
public void actionPerformed(ActionEvent ae) {
    int nextRow = table.getRowCount();
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.addRow(new Object[] {"" + nextRow, "" + nextRow});
    // the correct row is: nextRow. No loop required here.
    table.setDefaultRenderer(Object.class, new GrayWhiteRenderer(nextRow));
}