JButton btnCheck = new JButton("Check");
btnCheck.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        int count = 0;
        try{
            String conn = "select instrument, period, adminNo from reservation "
                        + "where adminNo = '" + txtAdmin.getText() + "'"; 
            PreparedStatement pst = sqliteConnection.dbConnector().prepareStatement(conn);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                count++;
                String adminNo = rs.getString("adminNo");
                if(txtAdmin.getText().equals(adminNo)){
                    System.out.println("Admin number from text: " + txtAdmin.getText() + "Admin number from DB: " + adminNo);
                lblDisplayMusicalInstrument.setText(rs.getString("instrument"));
                lblDisplayDuration.setText(rs.getString("period"));
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        if(count == 0) {
            JOptionPane.showMessageDialog(null, "Admin not in database");
        }

    }
});