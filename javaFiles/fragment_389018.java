@Entity
@Table(name = "subscription")
public class Subscription {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "subscription_id")
  private long id;

  @Column(name = "userid", nullable = false)
  private String userId;

  @Column(name = "saledate", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date saleDate;

  @Column(name = "finishdate", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date finishDate;

  @Column(name = "price", nullable = false)
  private long price;

  @Column(name = "description", nullable = false)
  private String description;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "associatedSub")
  private List<VisitDate> visitDates = new ArrayList<>();
}