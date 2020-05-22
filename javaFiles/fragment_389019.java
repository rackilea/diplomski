@Entity
@Table(name="visitdate")

public class VisitDate {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "date", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date         date;

  @ManyToOne
  @JoinColumn(name="subscription_id")
  private Subscription associatedSub;
}