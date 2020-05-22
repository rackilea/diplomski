Connection con = ...
List<String> sqlStatements = ... //a list with all the SELECT statements you have
for (String query : sqlStatements) {
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    while (rs.next()) {
        //do your logic here...
    }
    rs.close();
    stmt.close();
}
conn.close();