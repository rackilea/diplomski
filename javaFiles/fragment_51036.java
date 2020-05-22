@PrimaryKeyClass
public class Key implements Serializable {

    @PrimaryKeyColumn(name = "day_requested", ordinal = 0,
            type = PrimaryKeyType.PARTITIONED) 
    private LocalDate dayRequested;

    @PrimaryKeyColumn(name = "date_requested", ordinal = 1, type = PrimaryKeyType.CLUSTERED,
            ordering = Ordering.DESCENDING) 
    private LocalDateTime dateRequested;

}

@Table(value = "request_event")
public class RequestEvent {

    @PrimaryKey 
    private Key key;

}

public interface RequestEventRepository extends CrudRepository<RequestEvent, Key> {}

eventRepository.findOne(new Key(…))