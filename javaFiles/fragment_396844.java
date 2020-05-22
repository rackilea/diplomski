try {
      Object[] columnNames = { "year", "term", "balance" };
      DefaultTableModel model = new DefaultTableModel(columnNames, 0);
      while (rs.next()) {
         Vector<String> rowData = new Vector<>();
         rowData.add(rs.getString(1));
         rowData.add(rs.getString(2));
         rowData.add(rs.getString(3));
         row++;
         model.addRow(rowData);
      }
      table4.setModel(model);
   } catch (SQLException e1) {
      e1.printStackTrace();
   }