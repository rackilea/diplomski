CallableStatement cstmt = null;
try {
    DatabaseConnection dbConn = new DatabaseConnection();
    Connection conn = dbConn.initiateConnection();

    String SQL = "{call insertChildNode(?, ?)}";

    //CallableStatement cStmt = conn.prepareCall("{call demoSp(?, ?)}");

    cstmt = conn.prepareCall(SQL);

    cstmt.setInt(1, Integer.parseInt(nodeId));
    cstmt.setString(2, newNodeName);

    cstmt.execute();

    System.out.println("Query executed...");
} catch (SQLException e) {
    e.printStackTrace();
} finally {
    try {
        cstmt.close();

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}