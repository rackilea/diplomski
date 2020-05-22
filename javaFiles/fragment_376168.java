ResultSet rs = stat.executeQuery("select * from ABC; select * from DEF;");
while(rs.next()) {
    //Iterate through first resultset 
}
rs.close();
if (stat.getMoreResults()) {
    rs = stat.getResultSet();
    while(rs.next()) {
        //Iterate through second resultset 
    }
}
stat.close();