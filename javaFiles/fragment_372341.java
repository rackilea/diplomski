public static Connection createConnection() {
    if (connectionCount.length < 5) {
        Connection con = new Connection();
        //connectionCount[ConnectionUtils.getConArrayLength(connectionCount)] = con;
        connectionCount[connectionCount.length -1] = con;
        return con;
    } else return null;
}