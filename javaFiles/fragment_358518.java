public void interactiveRowSorterWrapperSharedXTable() {
    final DefaultTableModel tableModel = new DefaultTableModel(list.getElementCount(), 2) {

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return Integer.class;
        }

    };
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        tableModel.setValueAt(i, i, 0);
        tableModel.setValueAt(tableModel.getRowCount() - i, i, 1);
    }
    final JXTable master = new JXTable(tableModel);
    final TableSortController<TableModel> rowSorter = (TableSortController<TableModel>) master.getRowSorter();
    master.removeColumn(master.getColumn(0));
    final JXTable rowHeader = new JXTable(master.getModel());
    rowHeader.setAutoCreateRowSorter(false);
    rowHeader.removeColumn(rowHeader.getColumn(1));
    rowHeader.setRowSorter(new RowSorterWrapper<TableModel>(rowSorter));
    rowHeader.setSelectionModel(master.getSelectionModel());
    // need to disable selection update on one of the table's 
    // otherwise the selection is not kept in model coordinates
    rowHeader.setUpdateSelectionOnSort(false);
    JScrollPane scrollPane = new JScrollPane(master);
    scrollPane.setRowHeaderView(rowHeader);
    JXFrame frame = showInFrame(scrollPane, "xtables (wrapped sortController): shared model/selection");
    Action fireAllChanged = new AbstractAction("fireDataChanged") {

        @Override
        public void actionPerformed(ActionEvent e) {
            tableModel.fireTableDataChanged();
        }

    };
    addAction(frame, fireAllChanged);
    Action removeFirst = new AbstractAction("remove firstM") {

        @Override
        public void actionPerformed(ActionEvent e) {
            tableModel.removeRow(0);

        }
    };
    addAction(frame, removeFirst);
    Action removeLast = new AbstractAction("remove lastM") {

        @Override
        public void actionPerformed(ActionEvent e) {
            tableModel.removeRow(tableModel.getRowCount() - 1);

        }
    };
    addAction(frame, removeLast);
    Action filter = new AbstractAction("toggle filter") {

        @Override
        public void actionPerformed(ActionEvent e) {
            RowFilter filter = rowSorter.getRowFilter();
            if (filter == null) {
                rowSorter.setRowFilter(RowFilter.regexFilter("^1", 1));
            } else {
                rowSorter.setRowFilter(null);
            }

        }
    };
    addAction(frame, filter);
    addStatusMessage(frame, "row header example with RowSorterWrapper");
    show(frame);
}