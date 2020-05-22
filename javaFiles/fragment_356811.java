@Entity
@Table(name = "parent_table")
public class Parent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "parent_id")
  private Long parentId;

  private String firstName;
  private String lastName;

  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  List<Child> children = new ArrayList<>();
}