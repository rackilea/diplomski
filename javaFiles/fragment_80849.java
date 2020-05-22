class ParallelTables {
    static JScrollPane createTable() {
        DefaultTableModel model = new DefaultTableModel(100, 2);
        for (int row=model.getRowCount(); --row>=0;) {
            model.setValueAt(row, row, 0);
        }
        JTable table = new JTable(model);
        return new JScrollPane(table);
    }

    public static void main(String[] args) throws Exception {

        JScrollPane scrollerA = createTable();
        JScrollPane scrollerB = createTable();
        scrollerA.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        // the following statement binds the same BoundedRangeModel to both vertical scrollbars.
        scrollerA.getVerticalScrollBar().setModel(
                scrollerB.getVerticalScrollBar().getModel());
        JPanel panel = new JPanel();
        panel.add(scrollerA);
        panel.add(scrollerB);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}