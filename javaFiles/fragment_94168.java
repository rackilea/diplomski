public void createPanelWindsAloft() {
    pnlWindsAloftInfo = new javax.swing.JPanel();
    pnlWindsAloftInfo.setLayout(new java.awt.GridLayout(1, 0));

    pnlWindsAloftTable = new javax.swing.JPanel();
    pnlWindsAloftTable.setLayout(new BorderLayout());

    javax.swing.JTable tblWindsAloft = new javax.swing.JTable(
            new Model_TableWindsAloft(createDataForWindsTable()));

    JScrollPane scrollWindsAloft = new JScrollPane(tblWindsAloft,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    tblWindsAloft.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    tblWindsAloft.setFillsViewportHeight(true);
    pnlWindsAloftTable.add(scrollWindsAloft, BorderLayout.CENTER);

    pnlWindsAloftInfo.add(pnlWindsAloftTable);
    pnlWindsAloft.add(pnlWindsAloftInfo, java.awt.BorderLayout.CENTER);
}