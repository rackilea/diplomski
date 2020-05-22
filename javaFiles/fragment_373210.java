Connection connection = new getConnection();
Statement statement = connection.createStatement();

for (String query : queries) {
    statement.addBatch(query);
}
statement.executeBatch();
statement.close();
connection.close();