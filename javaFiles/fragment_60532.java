int[] ids = { 1, 2, 3, 4 };
StringBuilder sql = new StringBuilder();
sql.append("select jedi_name from jedi where id in(");
for (int i = 0; i < ids.length; i++) {
    sql.append("?");
    if(i+1 < ids.length){
        sql.append(",");
    }
}
sql.append(")");
System.out.println(sql.toString());

try (Connection con = DriverManager.getConnection(...)) {

    PreparedStatement stm = con.prepareStatement(sql.toString());
    for(int i=0; i < ids.length; i++){
        stm.setInt(i+1, ids[i]);
    }

    ResultSet rs = stm.executeQuery();
    while (rs.next()) {
        System.out.println(rs.getString("jedi_name"));
    }

} catch (SQLException e) {
    e.printStackTrace();
}