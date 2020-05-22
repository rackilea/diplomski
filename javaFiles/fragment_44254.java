@Entity
public class Aditional implements Serializable {
@Transient
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@Column(nullable=false)
private Date dateCreation;
@Column(nullable=false)
private Date dateFrom;
@Column(nullable=false)
private Date dateTo;
@ManyToOne
private Salesman salesman;
@OneToOne
@JoinColumn(name="salesBonus_id")
private SalesBonus salesBonusRegistry;
@ManyToMany(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
@Fetch(value = FetchMode.SUBSELECT)
private List<ProductBonus> productBonuses;
@OneToOne
@JoinColumn(name="salesmanPrize_id")
private Prize bestSalesman;
@OneToOne
@JoinColumn(name="campaignPrize_id")
private Prize productCampaign;