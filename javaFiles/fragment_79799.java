jtbSchedule = new org.jdesktop.swingx.JXTable(new MyTableModel());// Here you set a MyTableModel instance
  ...
  jtbSchedule.setModel(new javax.swing.table.DefaultTableModel(
       new Object [][] {
           {null, null, null, null}
       },
       new String [] {
           "Title 1", "Title 2", "Title 3", "Title 4"
       }
   )); // But here you override the table model setting a DefaultTableModel instance