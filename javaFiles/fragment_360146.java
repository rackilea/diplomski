private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          

    try {

        String sql = "UPDATE accounts SET LastName = ?, FirstName = ?, Cheque = ?, Savings = ? where id = ?";
        pst=conn.prepareStatement(sql);
        pst.setString(1,txtLastName.getText());
        pst.setString(2,txtFirstName.getText());                
        pst.setString(3,txtCheque.getText());
        pst.setString(4,txtSavings.getText());
        pst.setString(5,txtID.getText());
        int updatedRowCount = pst.executeUpdate();
        // no record with id = txtID
        if(updatedRowCount == 0) {

            pst.close();                

            sql = "insert into accounts (ID,LastName,FirstName,Cheque,Savings) values (?,?,?,?,?,?) ";
            pst = conn.prepareStatement(sql);
            pst.setString(1,txtID.getText());
            pst.setString(2,txtLastName.getText());
            pst.setString(3,txtFirstName.getText());
            pst.setString(4,txtCheque.getText());
            pst.setString(5,txtSavings.getText());
            pst.executeUpdate();

        }

        getAllAccounts();
        JOptionPane.showMessageDialog(null, updatedRowCount > 0 ? "Customer Updated" : "Customer Inserted");

    }
    catch(Exception e){
        getAllAccounts();
        JOptionPane.showMessageDialog(null, e);
    }
    finally {
        try{
            pst.close();
        }
        catch(Exception e) {
        }
    }
}