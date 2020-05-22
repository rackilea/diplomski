@Entity
public class UseCaseStatus implements Serializable {

    @EmbeddedId
    private UseCaseStatusId id;

    @MapsId("tracking")
    @ManyToOne
    @JoinColumn(name = "trackingId", updatable = false, nullable = false)
    private Tracking tracking;

    private String resourceId;
}