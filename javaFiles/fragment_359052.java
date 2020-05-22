@Override
public Statement map(List<String> keys, String value) {
    Insert statement = QueryBuilder.insertInto(KEYSPACE_NAME, TABLE_NAME);
    statement.value("id", keys.get(0));
    statement.value("name", keys.get(1));
    statement.value("sentence", value);
    return statement;
}