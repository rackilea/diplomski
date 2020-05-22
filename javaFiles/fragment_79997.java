String tableName = "SSPWO"; 
String desc = "[Description]";
String searchText = "apple";
PreparedStatement ps = con.prepareStatement(
        String.format("SELECT * FROM %s WHERE %s LIKE ?", tableName, desc)
        );
ps.setString(1, "%" + searchText + "%");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
    System.out.println(String.format("%d: %s", rs.getInt(1),rs.getString(2)));
}