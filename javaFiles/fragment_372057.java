String sql = "insert into asset_update(User) select (Concat(first_name), ' ', (last_name)) from user";
    pst = conn.prepareStatement(sql);
    int i = pst.executeUpdate();//since it is insert statement use executeUpdate()
    if(i>0){
          pst = conn.prepareStatement("Select User from asset_update");
          rs = pst.executeQuery();//since it is select statement use executeQuery()
          while (rs.next()) {
            String name = rs.getString("User");
            jComboBox_Users.addItem(name);
         }
    }