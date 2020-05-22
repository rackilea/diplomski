private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             


    try {
        String sql = "SELECT EmployeeID,FirstName,LastName,Designation,BasicSalary FROM EmployeeInfo WHERE EmployeeID =?";
        pst=conn.prepareStatement(sql);
        pst.setString(1,EmployeeIDSearchField.getText());

        rs = pst.executeQuery();
    if(rs.next()) { 
        String ID = rs.getString("EmployeeID");
        EmployeeIDField.setText(ID);
        String FN = rs.getString("FirstName");
        FirstNameField.setText(FN);
        String LN = rs.getString("LastName");
        LasNameField.setText(LN);
        String Des = rs.getString("Designation");
        DesignationField.setText(Des);
        String BS = rs.getString("BasicSalary");
        BasicSalaryField.setText(BS);

    }
    } catch (SQLException e ) {
    JOptionPane.showMessageDialog(null, e);

}

}