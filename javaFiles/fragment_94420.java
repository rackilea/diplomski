private static class MyColumnsModel extends DefaultTableColumnModel {

    private TableColumn deleteColumn(int idxView) {
        if (selectionModel != null) {
            selectionModel.removeIndexInterval(idxView, idxView);
        }
        TableColumn tc = tableColumns.remove(idxView);
        tc.removePropertyChangeListener(this);
        for (TableColumn tableColumn : tableColumns) {
            if (tableColumn.getModelIndex() > tc.getModelIndex()) {
                tableColumn.setModelIndex(tableColumn.getModelIndex() - 1);
            }
        }
        return tc;
    }
}