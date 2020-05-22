btnOpen.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        String jobNumber = txtJobNumber.getText();
        String sql = "SELECT Date FROM JOBCOSTS where Job_Number ='" +jobNumber+"'";
        try {
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()) {
            String date=rs.getString("Date");
            txtJobCostDate.setText(date);

            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
});