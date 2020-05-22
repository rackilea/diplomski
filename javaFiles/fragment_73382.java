@Embeddable
public class ProjectId implements Serializable {
    private Long subscriptionId;
    private String name;

@Entity
@Table(schema = "t")
public class Project {
    @EmbeddedId
    private ProjectId id;

    @ManyToOne
    @MapsId("subscriptionId")
    @JoinColumn(name = "subscriptionId", referencedColumnName = "id", insertable = false, updatable = false)
    private Subscription subscription;


@Entity
@Table(schema = "t")
public class Subscription {

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    @MapKey(name = "id")
    private Map<ProjectId, Project> projects = new HashMap<>();