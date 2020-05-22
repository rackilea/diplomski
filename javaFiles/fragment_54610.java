PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM `read_with_us`.`book_inventory` WHERE book_title = ?");
ps.setString(1, txt_booktitle.getText());
rs = ps.executeQuery();
int count = 0;
if(rs.next()){
   count = rs.getInt(1);
}