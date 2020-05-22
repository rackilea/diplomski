class EventBean {
    public Long eventId;
    public String title;

    @JsonDeserialize(using = CustomDeserializer.class)
    public String location;
}