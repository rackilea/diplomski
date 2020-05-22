public static void checkUser(JButton btnAddUser,JPanel jPanel3){
   try {
      sql = "SELECT accessLevel FROM user_accounts WHERE userName = 'admin'";
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      rs.first();
      int accessLvl = rs.getInt(1);
      if (accessLvl != 1){
          btnAddUser.setEnabled(false);
          jPanel3.setEnabled(false);
      }
  }
  catch(Exception e){
    JOptionPane.showMessageDialog(null, "Exception on Verifying User");
  }