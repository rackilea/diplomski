try{

     connectDB();
     Statement st = con.createStatement();
     rs = st.executeQuery("select * from tbl_day_sheet_status_reports");

    while(rs.next()){
     PB_cash.setText(rs.getDouble("Handing_Balance_(CASH)")+"");
     String sv = rs.getDouble("Handing_Balance_(CASH)")+"";
     sv =  PB_cash.getText();
     double billNumber = Double.valueOf(sv);
     sv = Double.toString((Double) billNumber);
     PB_cash.setText(sv);
     }
     con.close();

     }catch(Exception ex){
     JOptionPane.showMessageDialog(this, ex.getMessage());
     }