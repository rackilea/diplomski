@Value
public class ContactDTO {
    private Long id;
    private String name;
    private Long eventId;

    public ContactDTO(Long id, String name, String eventId, String event_id) {
        this.id = id;
        this.name = name;
        this.eventId = eventId != null ? eventId : event_id;
    }
}