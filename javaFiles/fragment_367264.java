public class DisplayPanel extends JFrame {

  public DisplayPanel() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
        { "Row2-Column1", "Row2-Column2", "Row2-Column3" } };
    Object columnNames[] = { "Column One", "Column Two", "Column Three" };

    JTable table = new JTable(rowData, columnNames);
    JScrollPane scrollPane = new JScrollPane(table);
    this.add(scrollPane, BorderLayout.CENTER);
    this.setSize(300, 150);
    // this.setVisible(true); this line should probably be called by the caller class now
  }
}