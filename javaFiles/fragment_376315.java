String columnNames = { "Starting Date", "Ending Date", ... };
DefaultTableModel model = new DefaultTableModel(columnNames, 0);

for (int i = 0; i < myList4.size(); i++)
{
    List row = myList4.get(i);
    model.addRow( row.toArray(...) );
}

JTable table = new JTable( model );