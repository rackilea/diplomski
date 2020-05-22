private final static String QUERY = "SELECT user_id, location FROM B.users WHERE user_id IN (%a)";

StringBuilder userList = new StringBuilder();
while(rs.next()) {
    long userId = rs.getLong(user_id);
    userList.append(userId);
    if (!rs.isLast()) {
        userList.append(",");
    }
}

String usersLocationQuery = QUERY.replaceAll("%a", userList.toString());
PreparedStatement psUsersLocation = conB.prepareStatement(usersLocationQuery);
ResultSet usersLocation = psUsersLocation.executeQuery();
// Do whatever with the locations