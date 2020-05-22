public JPanel buildUI() {
    String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};

    Object[][] data = {
            {"Mary", "Campione",
                    "Snowboarding", 5, new JComboBox(new Object[]{Boolean.TRUE, Boolean.FALSE})},
            {"Alison", "Huml",
                    "Rowing", 3, Boolean.FALSE},
            {"Kathy", "Walrath",
                    "Knitting", 2, Boolean.FALSE},
            {"Sharon", "Zakhour",
                    "Speed reading", 20, Boolean.TRUE},
            {"Philip", "Milne",
                    "Pool", 10, Boolean.TRUE
            }
    };


    final JTable table = new JTable(increase(data, 50), columnNames);
    JScrollPane scrollPane = new JScrollPane(table);
    JButton print = new JButton("Print");
    print.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                table.print();
            } catch (PrinterException e1) {
                e1.printStackTrace();
            }
        }
    });

    table.setDefaultRenderer(TableColumn.class, new TableCellRenderer());
    JPanel panel = new JPanel(new BorderLayout(5, 5));
    panel.add(scrollPane, BorderLayout.CENTER);
    panel.add(print, BorderLayout.SOUTH);
    JTextField textField = new JFormattedTextField();
    JSpinner spinner = new JSpinner(new SpinnerNumberModel());
    spinner.setEditor(textField);
    textField.setEditable(false);
    panel.add(spinner, BorderLayout.NORTH);


    panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, InputEvent.CTRL_DOWN_MASK), "doSomething" );
    panel.getActionMap().put("doSomething",new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("TEST OUT");
        }
    });
    table.putClientProperty("JTable.autoStartsEdit", Boolean.FALSE);
    return panel;
}

private Object[][] increase(Object[][] src, int times) {

    Object[][] out = new Object[src.length * times][];
    for (int i = 0; i < times; i++) {
        System.arraycopy(src, 0, out, i * src.length, src.length);
    }
    return out;
}

public JFrame getFrame(String name) {
    JFrame frame = new JFrame(name);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setContentPane(buildUI());
    frame.setSize(200, 200);
    frame.pack();

    return frame;

}

public static void main
        (String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            PrintTableTest ui = new PrintTableTest();
            JFrame frame = ui.getFrame("TABLE PRINT TEST");
            frame.setVisible(true);
        }
    });
}

private class TableCellRenderer extends DefaultTableCellRenderer {

    /**
     * Returns the default table cell renderer.
     *
     * @param table      the <code>JTable</code>
     * @param value      the value to assign to the cell at <code>[row, column]</code>
     * @param isSelected true if cell is selected
     * @param hasFocus   true if cell has focus
     * @param row        the row of the cell to render
     * @param column     the column of the cell to render
     * @return the default table cell renderer
     */
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row,
                                                   int column) {
        if (value instanceof JComboBox) {
            return (Component) value;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

    }
}