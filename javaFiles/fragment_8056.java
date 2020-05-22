public class SearchEvent extends GwtEvent<SearchEventHandler> {

    public static Type<SearchEventHandler> TYPE = new Type<SearchEventHandler>();
    public static enum TYPE {TYPE1,TYPE2}
    String toBeSearched;
    Widget sender;
    TYPE type;


    public SearchEvent(String aSearchString,Widget sender,TYPE type) {
        toBeSearched = aSearchString;
        this.sender = sender;
        this.type = type;
    }

    public String getToBeSearched() {
        return toBeSearched;
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<SearchEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(SearchEventHandler handler) {
        handler.onSearch(this);     
    }
}