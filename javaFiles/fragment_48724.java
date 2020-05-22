@Data
@Entity(name = "Notification")
@Table(name = "notification")
@TypeDef(
    name = "jsonb-node",
    typeClass = JsonNodeStringType.class
)
public class Notification extends NotificationBase {

    @Id
    @GeneratedValue
    @Column(name = "notification_id")
    private Long id;

    // This is when the object was created
    private Date updatedTime = new Date();

    private Date timestamp;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "notification_tag",
        joinColumns = { @JoinColumn(name = "notification_id") },
        inverseJoinColumns = { @JoinColumn(name = "tag_id") })
    private Set<Tags> tags = new HashSet<>();

    @Type(type = "jsonb-node")
    @Column(columnDefinition = "NVARCHAR(4000)")
    private JsonNode customJson;

}