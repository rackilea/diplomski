final JXTable table = new JXTable(3, 5);
    table.setVisibleRowCount(table.getRowCount());
    TableModelListener l = new TableModelListener() {

        @Override
        public void tableChanged(TableModelEvent e) {
            if (!(e.getType() == TableModelEvent.INSERT)) return;
            table.setVisibleRowCount(((TableModel) e.getSource()).getRowCount());
            RootPaneContainer frame = (RootPaneContainer) SwingUtilities.windowForComponent(table);
            ((JComponent) frame.getContentPane()).revalidate();
        }
    };
    table.getModel().addTableModelListener(l);
    Action insert = new AbstractAction("add row") {

        @Override
        public void actionPerformed(ActionEvent e) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[] {});
        }
    };
    new Timer(500, insert).start();
    JComponent comp = new JPanel(new MigLayout());
    comp.add(new JScrollPane(table));
    JXFrame frame = wrapInFrame(comp, "visibleRowCount");
    show(frame, frame.getPreferredSize().width, frame.getPreferredSize().height * 4);