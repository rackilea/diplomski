@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country")
    private Configuration country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "state")
    private Configuration state;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city")
    private Configuration city;

    @Column(name="zipcode") 
    private int zipCode;

    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;
     @Column(name = "status")
    private String status;
    @Column(name = "deleteFlag")
    private String deleteFlag;