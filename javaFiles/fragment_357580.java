ResultSet rs = SQLOperations.getAllUser(connection);            
Boolean add = true;
while (rs.next()) {
    String user=rs.getString("username");
    if(username.equalsIgnoreCase(user)){
        System.out.println("same username"); 
        add = false;
        break;
    }
}


if (add) {
    if (connection != null) {
        if (SQLOperations.addAccount(account, connection)){
            System.out.println("successful insert");
        } else {
            System.out.println("failed insert");
        }
    } else {
        System.out.println("invalid connection");
    }
}