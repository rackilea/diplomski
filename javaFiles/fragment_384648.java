@XmlRootElement(name = "nameSearchResponse")
public class NameSearchResponse extends SearchResponse<NameSearchResults>{

    @XmlElement(required = true)
    protected SearchRequest searchRequest;

    protected NameSearchResults searchResults;

    @Override
    public NameSearchResults getSearchResults() {
        return searchResults;
    }

    @Override
    public void setSearchResults(NameSearchResults mSearchResults) {
        this.searchResults = mSearchResults;
    }

    @Override
    public SearchRequest getSearchRequest() {
        return searchRequest;
    }

    @Override
    public void setSearchRequest(SearchRequest value) {
        this.searchRequest = value;
    }
}