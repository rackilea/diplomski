private void addColumn() {
    TableColumn tc = tableModel.addColumn();
    addColumn(tc); // equal to columnsModel.addColumn(tc);
}

private void deleteColumn(int idxView) {
    TableColumn tc = columnsModel.deleteColumn(idxView);
    tableModel.removeColumn(tc.getModelIndex());
}