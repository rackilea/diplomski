public void AddTables() {

    String dbShortName = combo.getSelectedItem().toString();
    String dbName = prop.get(dbNamesFile, dbShortName);

    int x = 50; int y = 150; int width = 150; int height = 220; //set Size and location 

    int [] indices = tblList.getSelectedIndices();

    panel = new PanelDraggable [indices.length];

    for (int i = 0; i < indices.length ; i++) {
        String tblName = tblList.getModel().getElementAt(i).toString();

        String sql = "SELECT `COLUMN_NAME` FROM `INFORMATION_SCHEMA`.`COLUMNS` WHERE "+
                 "`TABLE_SCHEMA`='"+dbName+"' AND `TABLE_NAME`='"+tblName+"'";

        JList<?> columnslist = new JList<String>();
        columnslist.setModel(getListModel(dbName, sql, 1));
        JScrollPane sc = new JScrollPane(columnslist);

        // There is an extra argument here. Whatever your 
        // mainPanel used to be in the static method
        panel[i] = new PanelDraggable(x, y , width, height, tblName, sc, mainPanel);
        panel[i].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered() {
                removeComp = (JComponent) e.getComponent();   
            }
        });

        mainPanel.add(panel[i]);
        x+=15;
        y+=20;

    }
    revalidate(); 
    repaint();
}

 public void RemoveTable() {
     this.remove(removeComp);
 }