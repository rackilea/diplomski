private static final String SQL_INSERT = "INSERT INTO CURRENT_WEATHER_US"
    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

public void create(String cityCode, Weather weather) throws SQLException {
    try (
        Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
    ) {
        statement.setString(1, cityCode);
        statement.setString(2, weather.getCity());
        statement.setString(3, weather.getRegion());
        // ...
        statement.setString(20, weather.getForecastCode());
        statement.executeUpdate();
    }
}