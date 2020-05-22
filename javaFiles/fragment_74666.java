@Entity
@Table(name = "command")
public class Command implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="command_se", sequenceName="COMMAND_SE", allocationSize=1, initialValue=1)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    // Refer the Composite key of Workflow entity

    @ManyToOne(optional = false)
    @JoinColumns ({
            @JoinColumn(name="WORKFLOW_SEQ_NO_ID", referencedColumnName = "SEQ_NO"),
            @JoinColumn(name="WORKFLOW_T_ID", referencedColumnName = "T_ID"),
    })
    private WorkflowStep workflow;
}