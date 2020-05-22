@Table(value = "request_event")
public class RequestEvent {

    @PrimaryKeyColumn(name = "day_requested", ordinal = 0,
            type = PrimaryKeyType.PARTITIONED) 
    private LocalDate dayRequested;

    @PrimaryKeyColumn(name = "date_requested", ordinal = 1, type = PrimaryKeyType.CLUSTERED,
            ordering = Ordering.DESCENDING) 
    private LocalDateTime dateRequested;

}

public interface RequestEventRepository extends CrudRepository<RequestEvent, MapId> {}

MapId mapId = BasicMapId.id("dayRequested", …).with("dateRequested", …);

RequestEvent loaded = eventRepository.findOne(mapId);