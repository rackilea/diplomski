public class CountFreeformQuery extends FreeformQuery {

private static final String QUERY_STRING_GROUP = "SELECT status, count(*) as num FROM foo GROUP BY status";
private static final String QUERY_STRING = "SELECT status, count(*) as num FROM foo";
private static final String GROUP_BY = "foo.status";

public CountFreeformQuery(JDBCConnectionPool connectionPool) {
    super(QUERY_STRING_GROUP, connectionPool);
    setDelegate(new CountAbstractFreeformStatementDelegate() {
        protected String getQueryString() {
            return QUERY_STRING;
        }

        protected String getGroupBy(){
            return GROUP_BY;
        }

    });
}
}