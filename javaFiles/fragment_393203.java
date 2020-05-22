PreparedStatement ps = conn.prepareStatement("SELECT name AS moniker, …");
ResultSet rset = ps.executeQuery();
while (rset.next()) {
    String name = rset.getString(1);
    System.out.println(rset.getMetaData().getColumnLabel(1)+ ": " + name …);
}