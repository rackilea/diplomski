@Entity
@Table(name="foos")
public class FooShort {

  public FooShort() {}
  @Id
  private Long id;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "bar_id")
  private Bar bar;

  @ManyToOne
  @JoinColumn(name = "bar1_id")
  private Bar1 bar1;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
  @JoinColumn(name = "foo_id")
  private List<Bar3> bar3;

  //getters and setters
}