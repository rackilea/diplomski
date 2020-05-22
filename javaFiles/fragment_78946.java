String sql = "INSERT INTO"
    + " APP.TRUMPS (TRUMPID, DEPART, ARRIVE, START, PLACES, PROPOSING_USER_LOGIN, CLOSING_HOURS)"
    + " VALUES (?, ?, ?, ?, ?, ?, ?)";
// ...

PreparedStatement preparedStatement = null;
// ...

try {
    // ...
    preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, newTrampTrumpistClient.login+dateForm.getText()+timeForm.getText());
    preparedStatement.setString(2, from);
    preparedStatement.setString(3, to);
    preparedStatement.setTimestamp(4, new Timestamp(calendar.getTimeInMillis()));
    preparedStatement.setInt(5, places);
    preparedStatement.setString(6, newTrampTrumpistClient.login);
    preparedStatement.setInt(7, closinghours);
    preparedStatement.executeUpdate();
    // ...
} finally {
    // ...
}