@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "USER")
public class User
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IDENTITY_USER")
  @EqualsAndHashCode.Include
  private Long identity;
}