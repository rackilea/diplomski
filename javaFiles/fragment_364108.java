JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

String[][] rowData = {
    { "A", "B" },
    { "C", "D" }
};
String[] columnNames = { "Column 1", "Column 2" };
JTable table = new JTable(rowData, columnNames);
frame.add(new JScrollPane(table));

frame.pack();
frame.setVisible(true);