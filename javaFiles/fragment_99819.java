DefaultTableModel table = (DefaultTableModel) jTable1.getModel();

 try
 {  String search3 = ManagerSearch.getText().toString();

    TableRowSorter<DefaultTableModel> sort = new TableRowSorter<>(table);
    jTable1.setRowSorter(sort);
    sort.setRowFilter(RowFilter.regexFilter(search3));

     BufferedReader br = new BufferedReader(new FileReader("managerinfo.txt"));
     String reader;

     while ((reader = br.readLine())!=null){
       if(reader.contains("Manager")){  
        table.addRow(reader.split("\\|"));
      }
     }
     br.close();
     View.setEnabled(false);
     Search.setEnabled(false);
 }
 catch (Exception e){
     JOptionPane.showMessageDialog(null,e+" ");
 }