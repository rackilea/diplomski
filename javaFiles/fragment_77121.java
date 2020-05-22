String sql="INSERT INTO players (player_uuid , name , age , gender , bios) "+
" VALUES (?,?,?,?,?)";
PreparedStatement pstmt=connection.prepareStatement(sql);
pstmt.setString(1,"UUID");
pstmt.setString(2,"TestName");
pstmt.setint(3,8);
pstmt.setString(4,"Female");
pstmt.setString(5,"TestBios");
pstmt.execute();
pstmt.close();