String sql = "SELECT * FROM foobar_table WHERE 1 = 1 ";
ArrayList paramList = new ArrayList();

if ( foo != 0 ) {
    sql += " AND foo=?";
    paramList.add(foo);
}

if ( !bar ) {
    sql += " AND bar=?";
    paramList.add(bar);
}

try{

    PreparedStatement getStmt = con.prepareStatement(sql);

    int index = 1;

    for (Object param : paramList) {
        getStmt.setObject(index, param);
        index++;
    }

    // execute

} catch (SQLException e ){
    e.printStackTrace();
}