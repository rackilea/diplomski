List entries = new ArrayList();
    for (int i = 0; i < 5; i++) {
        entries.add("entry " + i);
    }
    TableModel model = new MyTableModel(entries);
    JTable table = new JTable(model);
    table.getColumnModel().getColumn(0).setCellEditor(new MyCellEditor());
    table.getColumnModel().getColumn(0).setPreferredWidth(200);
    table.setRowHeight(50);