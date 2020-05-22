@Entity(name = "Event")
public class Event {
    private int event_id;
    private int owner_id;
    private String url1;
    private String url2;
    private String url3;
    public Event () {
        event_id = -1;
        owner_id = -1;
        url1 = "";
        url2 = "";
        url3 = "";
    }