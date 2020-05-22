model = new DefaultTableModel();
table = new JTable(model);

...query the database, do either:
model.setDataVector(...);
table.setModel(new DefaultTableModel(...));