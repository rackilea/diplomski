detailsTable = new JTable();
    detailsTable.setFillsViewportHeight(true);
    detailsTable.setModel(new DefaultTableModel(new Object[][] {},
            new String[] { "LAST_NAME", "FIRST_NAME"}));

scrollPane = new JScrollPane(detailsTable);
panel1.add(scrollPane);