public class SearchResult<T> {

    public List<T> results ;

    public Integer count ;

    public SearchResult(List<T> results, Integer count){
        this.results = results;
        this.count = count ;
    }
}