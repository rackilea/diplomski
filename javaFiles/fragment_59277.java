TypedTableModel cal1= new TypedTableModel();
cal1.addColumn("calification", String.class);
cal1.addRow("10");
cal1.addRow("10");

TypedTableModel cal2= new TypedTableModel();
cal2.addColumn("calification", String.class);
cal2.addRow("5");

TypedTableModel model = new TypedTableModel();
model.addColumn("studentId", String.class);
model.addColumn("studentName", String.class);
model.addColumn("califications", TypedTableModel.class);
model.addRow("1", "Name 1", cal1);
model.addRow("2", "Name 2", cal2);

TableDataFactory dataFactory = new TableDataFactory();
dataFactory.addTable("master-query", model);