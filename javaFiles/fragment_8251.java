@Test
public void test() {

    // original components
    JTable jTable = new JTable();
    JScrollPane scrollPane = new JScrollPane(jTable);

    // add them to tab
    JTabbedPane jTabbedPane = new JTabbedPane();
    jTabbedPane.addTab("tab1", scrollPane);
    jTabbedPane.setSelectedComponent(scrollPane);

    // get them out of selected tab
    JScrollPane scrollRef = (JScrollPane) jTabbedPane.getSelectedComponent();
    JTable tableRef = (JTable) scrollRef.getViewport().getComponents()[0];

    assertTrue(tableRef == jTable);
}