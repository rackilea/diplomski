@Entity
@Table(name = "children")
public class Child {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long childId;

  @ManyToOne
  @JoinColumn(name="parent_id")
  private Parent parent;

  private String name;

}