public class AreaDAO {
    private Database database;

    public AreaDAO(Database database) {
        this.database = database;
    }

    public List<Area> list() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Area> areas = new ArrayList<Area>();

        try {
            connection = database.getConnection();
            statement = connection.prepareStatement("SELECT location, timezone FROM userclient");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Area area = new Area();
                area.setLocation(resultSet.getString("location"));
                area.setTimezone(resultSet.getString("timezone"));
                areas.add(area);
            }
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException logOrIgnore) {}
            if (statement != null) try { statement.close(); } catch (SQLException logOrIgnore) {}
            if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
        }

        return areas;
    }
}