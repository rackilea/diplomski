stmt = "SELECT COUNT(*) AS Count FROM table_name";
int initialSize = 0;
rs = stmt.executeQuery(stmt);
while(rs.next){
  initialSize = Integer.parseInt(rs.getString("Count");
}