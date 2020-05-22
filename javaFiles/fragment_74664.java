@Entity
@Table(name = "workflow")
public class Workflow implements Serializable {

    @EmbeddedId
    private WorkflowPK id;

    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
}