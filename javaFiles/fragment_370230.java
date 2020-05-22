Statement statement = ...;
statement.setFetchSize(10000); // 10 000 rows for each page
final ResultSet resultSet = session.execute(statement);
final Iterator<Row> iterator = resultSet.iterator();
while (iterator.hasNext()) {
    Row row = iterator.next();
    // Process the row here
}