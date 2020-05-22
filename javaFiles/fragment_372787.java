sql = 
        "SELECT client_net_address, client_tcp_port, local_net_address, local_tcp_port " + 
        "FROM sys.dm_exec_connections " + 
        "WHERE session_id=@@SPID";
try (
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql)) {
    while (rs.next()) {
        System.out.printf("Connection is between %s:%d on the server and %s:%d as the client.%n", 
                rs.getString("local_net_address"),
                rs.getInt("local_tcp_port"),
                rs.getString("client_net_address"),
                rs.getInt("client_tcp_port")
                );
    }
}