private int setData(Connection conn,Object[] data){
     String sql = "INSERT INTO book VALUES(?,?)";
     PreparedStatement prepStm = conn.prepareStatement(sql);
     prepStm.setString(1,"Gulliver's Travels");
     prepStm.setInt(2,200);
     return prepStm.executeUpdate();
}