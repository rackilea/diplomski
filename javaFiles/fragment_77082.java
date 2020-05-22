public class Example extends JFrame {
    private static final long serialVersionUID = 811854316682851407L;
    private static final String[] COLUMNS = { "Current Chapter", "Chapter Online" };

    public Example() {
        super("test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTable table = new JTable(data(), COLUMNS);
        table.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
                    int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (c instanceof JLabel) {
                    JLabel renderer = (JLabel) c;
                    int valueAt = (int) table.getValueAt(row, column);
                    int compareValue = (int) table.getValueAt(row, column - 1);
                    if (compareValue < valueAt) {
                        renderer.setBackground(Color.GREEN);
                    } else {
                        if (isSelected)
                            renderer.setBackground(table.getSelectionBackground());
                        else {
                            renderer.setBackground(table.getBackground());
                        }
                    }
                }
                return c;
            }
        });
        JScrollPane sp = new JScrollPane(table);
        add(sp);
        pack();
        setLocationRelativeTo(null);
    }

    private Object[][] data() {
        Object[][] data = { { 113, 444 }, { 233, 555 }, { 110, 92 }, { 55, 66 }, { 123, 603 }, { 412, 120 }, };
        return data;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Example().setVisible(true));
    }
}