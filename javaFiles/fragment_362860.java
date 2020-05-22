@JacksonXmlRootElement(localName = "SomeRootObject")
public class SomeRootObject {
    @JsonProperty("Events")
    List<Event> events;
    public SomeRootObject() {

    }
    public List<Event> getEvents() {
        return events;
    }
    public void setEvents(List<Event> events) {
        this.events = events;
    }
}