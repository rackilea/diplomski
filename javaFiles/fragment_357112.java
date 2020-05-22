@Entity
@Table(name = "accesslogs")
public class AccessLog extends BaseEntity{

    @ManyToOne
    @JoinColumn
    private AuditableEntity actor;

    @ManyToOne
    @JoinColumn
    private AuditableEntity target;

    @Column(name="action_code")
    private String action;

    @Column(name="access_date")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime accessdate;

    //getters and setters
}