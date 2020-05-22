private void btnSandoghMousePressed(java.awt.event.MouseEvent evt){                                        
    try {
        String query = "SELECT `AccountType` FROM `account`"; 
        con = Connect.ConnectDB();
        PreparedStatement stm = con.prepareStatement(query); 
        pst = con.prepareStatement(query);                
        ResultSet rs = pst.executeQuery(query);
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        while (rs.next()) { 
            String groupName = rs.getString(4); 
            model.add(groupName);
        } 

        cmbSemetarID.setModel(model);
        rs.close();    
    } catch (SQLException e) {
    System.err.println("Connection Error! it's about date");
    }
}