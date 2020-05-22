public List<Person> list() throws SQLException {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<Person> persons = new ArrayList<Person>();

    try {
        connection = database.getConnection();
        statement = connection.createStatement("SELECT id, name, email, age FROM person");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getLong("id"));
            person.setName(resultSet.getString("name"));
            person.setEmail(resultSet.getString("email"));
            person.setAge(resultSet.getInteger("age"));
            persons.add(person);
        }
    } finally {
        if (resultSet != null) try { resultSet.close(); } catch (SQLException logOrIgnore) {}
        if (statement != null) try { statement.close(); } catch (SQLException logOrIgnore) {}
        if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
    }

    return persons;
}