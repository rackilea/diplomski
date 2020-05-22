DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnCount(1);
    modelo.addColumn("Prueba");
    tblTrans = new JTable(modelo);
    JScrollPane sPane = new JScrollPane(tblTrans);
    sPane.setBounds(316, 47, 248, 243);
    contentPane.add(sPane);