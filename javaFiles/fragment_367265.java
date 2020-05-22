public class DisplayPanel extends JFrame {

  public DisplayPanel(Object[][] rowData, Object[] columnNames) {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JTable table = new JTable(rowData, columnNames);
    JScrollPane scrollPane = new JScrollPane(table);
    this.add(scrollPane, BorderLayout.CENTER);
    this.setSize(300, 150);
    // this.setVisible(true); this line should probably be called by the caller class now
  }
}