private void jButtonActionPerformed(java.awt.event.ActionEvent evt){                                         
    Connection conn = null;
    PreparedStatement ps = null;

    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmgt","root","");
        ps = conn.prepareStatement("SELECT * FROM userprofile WHERE userName = ? AND passWord = ?");
        ps.setString(1, jTextField_userName.getText());
        ps.setString(2, String.valueOf(jPasswordField_login.getPassword()));
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
                String userType = rs.getString("emp_Type");
                if (userType.equals("ADMIN")){
                    this.setVisible(false);
                     Admin_Panel ap = new Admin_Panel();
                     ap.setVisible(true);
                     break;
                } else (userType.equals("RCEP")){
                    this.setVisible(false);
                    Admin_Panel ap = new Admin_Panel();
                     ap.setVisible(false);
                    Reception rcep = new Reception();
                    rcep.setVisible(true);
                    break;
                }

        } else{
            conn.close();
            JOptionPane.showMessageDialog(this,"UserName Or Password Invalid");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }

}