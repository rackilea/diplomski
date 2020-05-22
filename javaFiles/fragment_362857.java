@JacksonXmlRootElement(localName = "Event")
public class Event {
    @JsonProperty("EventID")
    private String eventID;
    @JsonProperty("Event")
    private int event;
    public String getEventID() {
        return eventID;
    }
    public void setEventID(String eventID) {
        this.eventID = eventID;
    }
    public int getEvent() {
        return event;
    }
    public void setEvent(int event) {
        this.event = event;
    }
}