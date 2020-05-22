@Entity
public class Business {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToMany(mappedBy = "parents")
  private Collection<Business> childrens;

  @ManyToMany
  private Collection<Business> parents;
}