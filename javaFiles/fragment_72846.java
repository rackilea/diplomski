stmt = conn.prepareStatement(UAppConstants.SELECT_USERID_BY_NAME);
stmt.setString(1, _username);
ResultSet rs2 = stmt.executeQuery();
if (rs2.next()) {
    int _id = rs2.getInt("UserID");
    // do something with the id
} else {
    // user not found
}