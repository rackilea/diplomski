@Entity
@Inheritance(strategy=InheritanceType.Joined)    
public abstract class AuditableEntity extends BaseEntity {

    @OneToMany(mappedBy="actor")
    private List<AccessLog> actorLogs;

    @OneToMany(mappedBy="target")
    private List<AccessLog> targetLogs;
}