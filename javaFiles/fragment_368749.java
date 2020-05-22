public class ResultWithQuery {

    private final Future<List<?>> future;
    private final  String query;


    public ResultWithQuery(Future<List<?>> future, String query) {
        this.future = future;
        this.query = query;
    }


    public Future<List<?>> getFuture() {
        return future;
    }


    public String getQuery() {
        return query;
    }

}