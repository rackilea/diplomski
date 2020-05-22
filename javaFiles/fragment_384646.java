@XmlRootElement(name = "searchResponseBase")
public abstract class SearchResponseBase<E>{

    public abstract E getSearchResults();

    public abstract void setSearchResults(E mSearchResults);

}