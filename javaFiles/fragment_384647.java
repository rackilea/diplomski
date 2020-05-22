@XmlRootElement(name = "searchResponse")
public abstract class SearchResponse<E> extends SearchResponseBase<E>{

    public abstract SearchRequest getSearchRequest();

    public abstract void setSearchRequest(SearchRequest value);   
}