connectDB();
try{
    java.sql.PreparedStatement stmt = con.prepareStatement("DELETE FROM tbl_codes WHERE No=? ");
    stmt.setString(1,txt_search_code.getText());
    stmt.execute();
    JOptionPane.showMessageDialog(null, " Your new records Deleted Succsessfully!!");   
} catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
}
closeDB();