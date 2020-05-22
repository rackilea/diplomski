public void mouseClicked(MouseEvent e) {
    if (cal == true) {
        try {
        int balchange = updatebal;
        String username = (String) userPicker.getSelectedItem();
        Connection conn = DriverManager.getConnection( Host, Name, Pass );  
        PreparedStatement pst = conn.prepareStatement("UPDATE table_1 SET user_bal=? WHERE user_name=?");

        pst.setInt(1, balchange);
        pst.setString(2, username);

        pst.execute();

        String sign = "£";
        String PayName = textField_1.getText();
        PreparedStatement pst2 = conn.prepareStatement("INSERT INTO payment_info (payment_name, payment_amount, payment_date, username)"
        + " VALUES (?, ?, ?, ?)");

        pst2.setString(1, PayName);
        pst2.setString(2, sign + balchange);
        pst2.setString(3, "Date");//if it's date column use ps2.setDate(3, new Date());
        pst2.setString(4, username);

        pst2.execute();
        cal = false;
        } 
        catch (Exception e3) {
        e3.printStackTrace();
        }
    }
    else {
        JOptionPane.showMessageDialog(null, "Please use the Calculator First!");
    }
}