public class Thing<T> {
    private T data;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
    @JsonSubTypes({
      @JsonSubTypes.Type(Link.class),
      @JsonSubTypes.Type(Listing.class)
    })
    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }
}