PreparedStatement psUserLocation = conB.prepareStatement("SELECT location FROM B.users WHERE user_id = ?");
while(rs.next()) {
    //call select statement for database B to get the location for each user id
    long userId = rs.getLong(user_id);
    psUserLocation.setLong(1, userId)
    ResultSet userLocation = ps.executeQuery();
    // Do whatever with the location(s)
}