Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("show create table BLA.MY_TABLE");
if(rs.next()) {
       System.out.println("Table Name: "+rs.getString(1));
       System.out.println("SQL Code: "+rs.getString(2));
}
rs.close();
stmt.close();