User user = new User("Zack", "Yoshyaro");

DefaultTableModel model = new DefaultTableModel(new Object[]{"First", "Last"}, 0);
model.addRow(new Object[]{user, user});  // note user must be added for each column, but it's the same object
JTable table = new JTable(model);

TableColumn firstName = table.getColumn("First");
firstName.setCellRenderer(...); // a cell renderer that shows user.getFirstName();

TableColumn lastName = table.getColumn("Last");
lastName.setCellRenderer(...); // a cell renderer that shows user.getLastName();