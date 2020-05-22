try (PreparedStatement ps = 
    connection.prepareStatement("INSERT INTO PlayerList (nickname, uuid, firstjoined) VALUES (?, ?, CURDATE())")) {
    ps.setString(1, nickName);
    ps.setString(2, uuid);
    int i = ps.executeUpdate();

}