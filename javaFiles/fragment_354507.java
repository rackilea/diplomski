ResultSet rs = null;
try {
    try {
        connection = ConnectionFactoryJndi.getConnection(); //always do this everytime you need a conenction.
        statement = connection.createStatement();
    } catch (SQLException e) {
        log.error("Error in Client DAO class (unable to connect connection) "
                + e.getMessage());
        // e.printStackTrace();
    }
    try {
        if(statement != null){
            rs = statement.executeQuery(query);
        }else{
            //log error and return or throw exception
        }
    } catch (SQLException e) {
        log.error("Error in Client DAO class (unable to Execute Query ) "
                + e.getMessage());
        // e.printStackTrace();
    }

    try {
        if(rs != null){
            while (rs.next()) {
                client = new ClientTO();
                client.setClientId(rs.getInt("clientid"));
                client.setClientUrl(rs.getString("clienturl"));
                client.setClientSecurityKey(rs
                        .getString("clientserviceapiKey"));

                clientList.add(client);
            }
        }else{
            //log error and return or throw exception
        }
    } catch (SQLException e) {
        log.error("Error in Client DAO class ( Error in iteration ) "
                + e.getMessage());
        // e.printStackTrace();
    }
} finally {
    //close rs
    //close statement
    //never close a conenction
}