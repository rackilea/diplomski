@Embeddable
public class WorkflowPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "SEQ_NO")
    private int seqNo;

    @JoinColumn(name = "T_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne
    private Template template;
}