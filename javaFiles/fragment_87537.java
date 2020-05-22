void getAutoResizeTable(final JTable table) {

    table.getColumnModel().addColumnModelListener(new TableColumnModelListener() {
        @Override
        public void columnSelectionChanged(ListSelectionEvent lse) {
        }

        @Override
        public void columnAdded(TableColumnModelEvent tcme) {
        }

        @Override
        public void columnRemoved(TableColumnModelEvent tcme) {
        }

        @Override
        public void columnMoved(TableColumnModelEvent tcme) {
        }

        @Override
        public void columnMarginChanged(ChangeEvent ce) {
            TableColumn resizingColumn = table.getTableHeader().getResizingColumn();
            if (resizingColumn != null) {
                resizingColumn.setPreferredWidth(resizingColumn.getWidth());
            }
            if (hasExcessWidth(table)) {
                table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
            } else {
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            }

        }

        protected boolean hasExcessWidth(JTable table) {
            return table.getPreferredSize().width < table.getParent().getWidth();
        }

    });

}