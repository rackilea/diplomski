public static class MyJTable extends JTable {
    public MyJTable(TableModel tm) {
        super(tm);
    }

    @Override
    public MyAccessibleJTable getAccessibleContext() {
        if (accessibleContext == null) {
            accessibleContext = new MyAccessibleJTable();
        }
        return (MyAccessibleJTable)accessibleContext;
    }

    protected class MyAccessibleJTable extends AccessibleJTable {

        @Override
        public int getAccessibleChildrenCount() {
            if (MyJTable.this.getColumnCount() <= 0) {
                return 0;
            }
            return MyJTable.this.getRowCount();
        }

        @Override
        public Accessible getAccessibleChild(int i) {
            if (i < 0 || getAccessibleChildrenCount() <= i) {
                return null;
            }
            TableColumn firstColumn = getColumnModel().getColumn(0);
            TableCellRenderer renderer = firstColumn.getCellRenderer();
            if (renderer == null) {
                Class<?> columnClass = getColumnClass(0);
                renderer = getDefaultRenderer(columnClass);
            }
            Component component = renderer.getTableCellRendererComponent(MyJTable.this, null, false, false, i, 0);
            return new MyAccessibleRow(MyJTable.this, i, component);
        }
    }

    protected static class MyAccessibleRow extends AccessibleContext implements Accessible {
        private MyJTable table;
        private int row;
        private Component rendererComponent;

        protected MyAccessibleRow(MyJTable table, int row, Component renderComponent) {
            this.table = table;
            this.row = row;
            this.rendererComponent = rendererComponent;
        }

        @Override
        public AccessibleRole getAccessibleRole() {
            // ROW_HEADER is used because it maps to NSAccessibilityRowRole
            // on Mac.
            return AccessibleRole.ROW_HEADER;
        }

        @Override
        public Locale getLocale() {
            AccessibleContext ac = rendererComponent.getAccessibleContext();
            if (ac != null) {
                return ac.getLocale();
            } else {
                return null;
            }
        }

        @Override
        public int getAccessibleChildrenCount() {
            return 0; // TODO return the number of columns in this row
        }
        @Override
        public Accessible getAccessibleChild(int i) {
            return null; // TODO return a MyAccessibleJTableCell
        }
        @Override
        public int getAccessibleIndexInParent() {
            return row;
        }
        @Override
        public AccessibleStateSet getAccessibleStateSet() {
            return null; // TODO
        }
        @Override
        public AccessibleContext getAccessibleContext() {
            return this; // TODO
        }
        @Override
        public AccessibleComponent getAccessibleComponent() {
            return table.getAccessibleContext(); // TODO
        }
    }
}