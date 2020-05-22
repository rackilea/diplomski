@Entity
@Table(name = "COMPANY")
@SequenceGenerator(name="CompanySeq", sequenceName="COMPANYseq", allocationSize=1)
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
     * Customer Company Details 
     */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CompanySeq")
    @Column(name = "COMPANY_ID")
    private Integer id;

    @Column(name="COMPANY_NAME")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID",nullable=false)
    @OrderBy(clause = "PRODUCT_NAME" )
    @ForeignKey(name = "fk_company_product")     
    private List<Product> products = new ArrayList<Product>();    

 }



 @Entity
@Table(name = "PRODUCT")
@SequenceGenerator(name="CompanyProductSeq", sequenceName="COMPANY_PRODUCT",  allocationSize=1)
public class Product implements Serializable{

    /**
     * SerialVersion ID
     */
    private static final long serialVersionUID = 4073418246832063389L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CompanyProductSeq")
    @Column(name = "PRODUCT_ID")
    private Integer id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID", updatable = false, insertable = false, nullable=false)  
    private Company companyId;

        @Column(name = "PRODUCT_NAME")
    private String name;

    }