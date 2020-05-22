TryingTableModel tableModel = new TryingTableModel(currentTable, tableArray, columnNames);
tableModel.addTableModelListener(new TableModelListener() {

    @Override
    public void tableChanged(TableModelEvent tme) {
    TryingTableModel tableModel = (TryingTableModel) tme.getSource();
    System.out.println(tableModel.testAccess());
    }
});

JTable newJTable = new JTable(tableModel);