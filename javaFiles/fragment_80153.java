final String sql = "SELECT x, y, Icoon FROM spelbord WHERE spelID = ? AND spelbordID = ?";

query = conn.prepareStatement(sql);
query.setString(1, your_spel_id);
query.setString(2, your_spel_bord_id);

rs = query.executeQuery();
while(rs.next()) {

}