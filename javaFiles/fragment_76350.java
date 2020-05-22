public static Course getById(int id) throws SQLException {
    String query = "SELECT * FROM courses WHERE id = ?";

    try (
        Connection connection = DriverManager.getConnection(ConnectDb.CONN_STRING, ConnectDb.USERNAME, ConnectDb.PASSWORD);
        PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    ) {
        statement.setInt(1, id);
        statement.setMaxRows(1);
        try (
            ResultSet resultSet = statement.executeQuery();
        ) {
            if (resultSet.next()) {
                Course course = new Course();
                course.setId(resultSet.getInt("id"));
                course.setName(resultSet.getString("name"));
                course.setTeacherId(resultSet.getInt("teacher_id"));
                return course;
            }

            // No matching course
            return null;
        }
    }

} // end of method