public void DoSave()    {
           try{   
               String host1 = "jdbc:derby://localhost:1527//accountsdb";
               String uName1="accounts";
  String uPass1="accounts";
   con1=DriverManager.getConnection(host1,uName1 ,uPass1);
   String sql1="INSERT into journal (journal_no,journal_date,journal_submain_no,journal_dr,journal_cr,journal_desc,journal_user,journal_docno) values (?,?,?,?,?,?,?,?)";

PreparedStatement pst=con1.prepareStatement(sql1);
pst.setInt(1,Integer.parseInt(jLvoucher_no.getText().trim()) );
pst.setString(2,((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
 pst.setInt(3,Integer.parseInt(jTjournal_submain_no.getText().trim()) );
 pst.setInt(4,Integer.parseInt(jTjournal_amount.getText().trim()) ); //Dr
pst.setInt(5,Integer.parseInt(jTjournal_amount.getText().trim()) );//Cr
pst.setString(6,jTjournal_desc.getText().trim() );
 pst.setString(7,Frmlogin.myname );
 pst.setString(8,jTjournal_docno.getText().trim() );
 pst.execute();
 JOptionPane.showMessageDialog(null, "Saved");




  }               
  catch (SQLException ex) {
      System.out.println(ex.getMessage())   ;      
}
   }