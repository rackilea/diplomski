JTable table = new JTable();
table.getModel().addTableModelListener(new TableModelListener() {

        @Override
        public void tableChanged(TableModelEvent e) {
            if (e.getType()==TableModelEvent.INSERT||e.getType()==TableModelEvent.DELETE) {
                // Do something
            }
        }
    });