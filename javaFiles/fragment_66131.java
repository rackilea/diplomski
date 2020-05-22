String cc = txtCC.getText();
    String delimiter = ",";
    String[] temp;
    temp = cc.split(delimiter);
    for(int i = 0; i < temp.length; i++)
        insertData(temp[i]);

} 


public void insertData(final String data){
            txtC1.setText(data);

        try {
            String cc1 = txtC1.getText(); int CC1 = Integer.parseInt(cc1);

            int opt = JOptionPane.showConfirmDialog(null,"Are you sure you want to save this record? ");
            if (opt == 0){
                if(!txtC1.getText().equals("0")) {
                    stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    String sql = "Select * from tbl_liqinfo";
                    rs = stmt.executeQuery(sql);
                    rs.next();
                    rs.moveToInsertRow();
                    rs.updateInt("CC", CC1);
                    rs.insertRow();
                    rs.close();
                }

            }
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(FrmEmpLiquidation.this, err.getMessage());
        }
}