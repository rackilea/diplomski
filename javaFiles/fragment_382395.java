table = new JTable(model);
    table3 = new JTable(model1);


    table.setRowHeight(30);
    table3.setRowHeight(30);
    JScrollPane scroll=new JScrollPane(table);
    JScrollPane scroll1=new JScrollPane(table3);
    tablePanel.add(scroll1);
    tablePanel.add(scroll);