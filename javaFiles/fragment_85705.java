Connection conn = hikariDataSource.getConnection();
Function.create(connection.unwrap(SQLiteConnection.class),
                "title_sort",
                new Function() {
                   @Override
                   protected void xFunc() throws SQLException {
                      result(value_text(0));
                   }
                }
);