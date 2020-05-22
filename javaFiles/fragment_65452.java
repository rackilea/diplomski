ResultSet rs = statement.executeQuery("SELECT isAdmin FROM users WHERE name LIKE '"+nameValue+"' AND password LIKE '"+passValue");
if(rs.next()){
    if(rs.getBoolean()){
    // redirect to admin.jsp
    }
    else {
    // redirect to user.jsp
    }
} else {
 // user or password invalid
}