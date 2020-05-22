@Entity
@Table(name = "template")
public class Template implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="template_se", sequenceName="TEMPLATE_SE", allocationSize=1, initialValue=1)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "NAME", unique = true)
    private String name;

    // Refer the filed "template" inside the Composite key of Workflow entity

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "id.template")
    @LazyCollection(LazyCollectionOption.FALSE)
    @OrderBy(value = "id.stepSeqNo")
    private List<Workflow> workflowList;
}