String sql ="select * from patient where p_id=?";
pst =conn.prepareStatement(sql);
pst.setInt(1, Integer.parseInt(Table_click));
//in case p_id is a VARCHAR, comment above line and uncomment below line
//pst.setString(1, Table_click);
rs=pst.executeQuery();
//rest of code...