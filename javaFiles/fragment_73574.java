Connection var2 = DBConnPool.getInstance().getConnection();
Statement var3 = null;
Statement stmQuery = null;
String var5;
ResultSet var8 = null;

try {
    var3 = var2.createStatement();
    stmQuery = var2.createStatement();

    var5 = "insert into triggers (ts, nodeip, trapname) values (now(), '"+ipaddress+"', '"+trapname+"')";
    var3.execute(var5);

    var5 = "select asset.id as assetid, node.id as nodeid \n" +
        "from asset, node\n" +
        "where asset.name LIKE 'Trigger%'\n" +
        "and node.ipaddress=\'"+ipaddress+"'";
    var8 = stmQuery.executeQuery(var5);

    while(var8.next()){
        int var31 = var8.getInt("assetid");
        int var32 = var8.getInt("nodeid");

        var5 = "insert into alerts (ts, assetid, alerttypeid, nodeid, ack) values (now(), " + var31 + ", 15, " + var32 + ", 0)";
        var3.execute(var5);
        var5 ="insert into logs (ts, rssi, nodeid, assetid) values (now(), 1000, " + var32 + ", " + var31 + ")";
        var3.execute(var5);
    }
} catch (Exception e) {
    //Somthing went wrong!
} finally {
    var3.close();
    stmQuery.close();
    var8.close();
    var2.close();
}