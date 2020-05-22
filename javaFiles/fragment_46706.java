@Entity
@Table(name = "Expenses")
public class Expense {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonIgnoreProperties("expenses")
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  private Double amount;
.....