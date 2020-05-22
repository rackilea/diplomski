class ProcessFreeformQuery extends FreeformQuery {

private static final String QUERY_STRING = "SELECT request_date, status, id_foo FROM foo";
private static final String COUNT_STRING = "SELECT COUNT(*) FROM foo";
private static final String PK_COLUMN_NAME = "id_foo";

MyFreeformQuery(JDBCConnectionPool connectionPool) {
    super(QUERY_STRING, connectionPool, PK_COLUMN_NAME);
    setDelegate(new AbstractFreeformStatementDelegate() {

        protected String getPkColumnName() {
            return PK_COLUMN_NAME;
        }

        protected String getQueryString() {
            return QUERY_STRING;
        }

        protected String getCountString() {
            return COUNT_STRING;
        }
    });
}