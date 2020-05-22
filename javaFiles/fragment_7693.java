public class FontTable extends JPanel {

    JTable table;

    FontTable() {

        Object[][] data = {{"aaa", "122", "_____"}, {",,,,,", ",,,", ",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,"}};
        Object[] names = {"C1", "C2", "C3"};
        table = new JTable(data, names);

        InputMap im = table.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        im.put(KeyStroke.getKeyStroke('=', InputEvent.CTRL_DOWN_MASK), "zoom in");
        im.put(KeyStroke.getKeyStroke('-', InputEvent.CTRL_DOWN_MASK), "zoom out");
        table.getActionMap().put("zoom in", new ZoomAction(true));
        table.getActionMap().put("zoom out", new ZoomAction(false));

        setLayout(new BorderLayout());
        add(new JScrollPane(table));
    }

    class ZoomAction extends AbstractAction {

        boolean in;

        ZoomAction(boolean in) {

            this.in = in;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            Font oldFont = table.getFont();
            float size = oldFont.getSize() + (in ? +2 : -2);
            table.setFont(oldFont.deriveFont(size));

            for (int row = 0; row < table.getRowCount(); row++) {
                int rowHeight = table.getRowHeight(row);

                for (int col = 0; col < table.getColumnCount(); col++) {
                    Component comp = table.prepareRenderer(table.getCellRenderer(row, col), row, col);
                    TableColumn column = table.getColumnModel().getColumn(col);
                    int colWidth = column.getWidth();

                    rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
                    colWidth = comp.getPreferredSize().width;

                    column.setPreferredWidth(colWidth);
                }
                table.setRowHeight(row, rowHeight);
            }
        }
    }
}