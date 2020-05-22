public void init() {
    //...
    //Jtable attribute and location
    JTable table = new JTable();
    table.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                    },
                    new String[]{
                        "name", "TypeDebt", " amount ", "DateDebt", "Due_Date"
                    }
    ));

    table.setPreferredScrollableViewportSize(new Dimension(300, 400));
    table.setSelectionBackground(getBackground());

    JScrollPane scrollpane = new JScrollPane(table);

    scrollpane.setBounds(200, 60, 490, 490);
    background.add(scrollpane);