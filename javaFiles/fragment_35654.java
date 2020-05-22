public boolean isPlayerInDataBase(Player p) {
    Connection connection = sql.getConnection();
    try (PreparedStatement select = connection.prepareStatement(
            "SELECT * FROM `MurderData` WHERE uuid='" + p.getUniqueId().toString() + "'")) {

        ResultSet result = select.executeQuery();
        if (result.next()) {
            CloseResultSet(result);
            return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}