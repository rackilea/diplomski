public interface CloudEventMixIn<T> {

     @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
            property = "eventType",
            defaultImpl = Void.class)
    @JsonSubTypes({
            @JsonSubTypes.Type(value = MyEvent1.class, name = "event-1"),
            @JsonSubTypes.Type(value = MyEvent2.class, name = "event-2")
    })
    public T getData();
}