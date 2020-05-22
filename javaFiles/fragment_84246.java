String sql = "select * from customers";
      preparedStatement=connect.prepareStatement(sql);
      resultSet=preparedStatement.executeQuery();
      Table_customer.setModel(DbUtils.resultSetToTableModel(resultSet));
//this part forces the premade pallet Jtable to morph 
//into the model of my mysql server database table