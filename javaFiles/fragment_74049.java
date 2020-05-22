@SuppressWarnings("serial")
class TablePanel extends JPanel {
    private static final String[] COL_NAMES = { "Name", "Surname", "ID" };
    private DefaultTableModel model = new DefaultTableModel(COL_NAMES, 0);
    private JTable table = new JTable(model);
    private Random random = new Random();

    public TablePanel() {
        setLayout(new BorderLayout());
        add(new JScrollPane(table));
    }

    public void clearTable() {
        model.setRowCount(0);
    }

    // fill it with random text and data
    public void fillTable() {
        int rows = random.nextInt(50) + 40;
        for (int i = 0; i < rows; i++) {
            StringBuilder sb = new StringBuilder();
            char c = (char) ('A' + random.nextInt(26));
            sb.append(c);
            for (int j = 0; j < 4 + random.nextInt(3); j++) {
                sb.append((char) ('a' + random.nextInt(26)));
            }
            String name = sb.toString();

            sb.delete(0, sb.length());
            sb.append((char) ('A' + random.nextInt(26)));
            for (int j = 0; j < 6 + random.nextInt(4); j++) {
                sb.append((char) ('a' + random.nextInt(26)));
            }
            String surName = sb.toString();

            int id = random.nextInt(Integer.MAX_VALUE / 2);

            Object[] rowData = { name, surName, id };
            model.addRow(rowData);
        }
    }
}