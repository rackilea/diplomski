Statement statement = getStatement();
try {
    ResultSet rs = executeQuery(statement, query);
    ...
} finally {
    statement.close();
}