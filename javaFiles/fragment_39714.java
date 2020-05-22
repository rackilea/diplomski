public static void main(String[] args) {
  String[] col = { "COLA", "COLB", "COLC" };
  Object[][] data = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
  DefaultTableModel model = new DefaultTableModel(data, col);
  JTable table = new JTable(model);
  JFrame frame = new JFrame();
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.getContentPane().add(new JScrollPane(table));
  frame.setVisible(true);
}