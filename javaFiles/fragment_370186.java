// table has two columns: id (AutoNumber), and lastname (Text(100))
Table tbl = db.getTable("customer");
Object[] newRow = new Object[] {Column.AUTO_NUMBER, "Thompson" };
tbl.addRow(newRow);
int newId = (int) newRow[0];
System.out.printf("New row was assigned AutoNumber value %d%n", newId);