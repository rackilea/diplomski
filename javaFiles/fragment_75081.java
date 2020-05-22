public class QueryResolver {

    Filter filter;
    String query;

    public QueryResolver where(String queryStr) {
        this.query = queryStr;
        return this;        
    }

    public QueryResolver matches(String filterStr) {
        this.filter = new Filter(filterStr);
        return this;        
    }

    public int count() {
        int result = 0;
        for(int i = 0; i < query.length(); i++) {
            if(filter.contains(query.charAt(i))){
                result++;
            }
        }
        return result;
    }

}