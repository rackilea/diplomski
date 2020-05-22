public class TheMatrix extends JFrame {

    JTable table;

    public TheMatrix() {
        setLayout(new FlowLayout());
        String[] columNames = {"", "", "", "", "", "", "", "", "", ""};

        Object[][] data = { // Create a 10*10 table with default values.

            {null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null}
        };

        table = new JTable(data, columNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 500));
        table.setRowHeight(40);
        table.setDefaultRenderer(Object.class, new MyRenderer());

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
}

class MyRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                    boolean hasFocus, int row, int col) {
        JTextField cell = new JTextField();

        cell.setBackground(((row % 2) == 0) && ((col % 2) == 0) ? Color.WHITE : Color.BLACK);
        return cell;
      }
}