public static void main(String[] args) {
    // TODO Auto-generated method stub
    final JFrame frame = new JFrame();
    final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    frame.setContentPane(tabbedPane);
    final Object rowData[][] = {
            { "Row1-Column1", "Row1-Column2", "", "", "", "", "" },
            { "Row1-Column1", "Row1-Column2", "", "", "", "", "" },
            { "Row1-Column1", "Row1-Column2", "", "", "", "", "" },
            { "Row1-Column1", "Row1-Column2", "", "", "", "", "" },
            { "Row1-Column1", "Row1-Column2", "", "", "", "", "" },
            { "Row2-Column1", "Row2-Column2", "Row2-Column3", "", "", "",
                    "", "" } };
    Object columnNames[] = { "Column One", "Column Two", "Column Three",
            "", "", "", "" };
    final JTable table = new JTable(rowData, columnNames);
    final JScrollPane scrollPane = new JScrollPane(table);

    tabbedPane.addTab("table", null, scrollPane, null);
    frame.setSize(new Dimension(500, 500));

    tabbedPane.addComponentListener(new ComponentListener() {

        @Override
        public void componentShown(ComponentEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void componentResized(ComponentEvent arg0) {
            // TODO Auto-generated method stub

            int scrollPaneHeight = scrollPane.getHeight();
            JTableHeader header = table.getTableHeader();
            int heightOfheaderOfTabel = header.getHeight();
            int spaceForRows = scrollPaneHeight - heightOfheaderOfTabel;
            float rowH = (float) spaceForRows / (rowData.length);
            table.setRowHeight((int) rowH);

        }

        @Override
        public void componentMoved(ComponentEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void componentHidden(ComponentEvent arg0) {
            // TODO Auto-generated method stub

        }
    });

    frame.setVisible(true);

}