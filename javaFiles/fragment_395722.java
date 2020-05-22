@Entity
@Table(name="part")
@SecondaryTable(name="supplement", pkJoinColumns ={@PrimaryKeyJoinColumn="id"})
public class Part{
    @Id
    @GeneratedValue
    private Integer id;

    private String poNo;

    private String partNo;

    private String partDesc;

    private String eccNo;
    @Column(table="supplement")
    @Basic(optional=true)
    private String vernderPartNo;
    @Column(table="supplement")
    @Basic(optional=true)
    private String exportHSCCode;
    ...
    getter and setter...
}