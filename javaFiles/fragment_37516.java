// Knows how to connect to the database
interface IDatabaseWriter {
  void create(Query query);
  void insert(Query query);
  ...
}

// Knows how to connect to the database
interface IDatabaseReader {
  QueryResult readTable(string tableName);
  QueryResult read(Query query);
  ...
}