String insertCql = "INSERT INTO ks.tb (...) values (?,?,...)";
for (Row row : rs) {
    List bindVariables = new ArrayList();
    for (int i = 0; i < rs.getColumnDefinitions().size(); i++) {
        bindVariables.add(rs.getObject(i));
    }
    final BoundStatement boundStatement = preparedStatement.bind(bindVariables.toArray(new Object[0]));
    session.execute(boundStatement);
}