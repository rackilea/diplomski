if (db.getConn() == null){
    throw new RuntimeException("Method Error! You Are NOT Connected To Database!");
}

String suppliedUserName = getUsername();
String dbUserName = "";
String SQL = "SELECT username FROM users WHERE username=?";

PreparedStatement preparedStatement = db.getConn().prepareStatement(SQL);
preparedStatement.setString(1, suppliedUserName);
ResultSet rs = preparedStatement.executeQuery();

while (rs.next()) {
    dbUserName = rs.getString("username");
}
rs.close()
preparedStatement.close()

/* Below we use the equalsIgnoreCase() method. You 
   don't want a supplied User Name to be that close 
   or that similar to another User Name already in 
   Database. If you do then just use equals() method.  */
if (dbUserName.equalsIgnoreCase(suppliedUserName)) {
    System.out.println("The User name (" + suppliedUserName + 
                ") is already in use. Try another User Name.");
    return false;
}
else {
    System.out.println("The User name (" + suppliedUserName + ") is Unique.");
    return true;
}