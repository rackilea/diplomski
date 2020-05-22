ListSqlOperatorTable listOpTable = new ListSqlOperatorTable();
listOpTable.add(my_udf);
ChainedSqlOperatorTable chainedOpTable = ChainedSqlOperatorTable.of(listOpTable, SqlStdOperatorTable.instance());
// then use this chainedOpTable

// If you want to use a special dialect operators, you can code like this
SqlOperatorTable optable = SqlLibraryOperatorTableFactory.INSTANCE
  .getOperatorTable(SqlLibrary.STANDARD, SqlLibrary.POSTGRESQL);