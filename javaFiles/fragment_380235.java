@Entity
@Table(name = "ItemsFinall")
public class ItemsFinall {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;

  //instead of: private int ItemId;
  @OneToMany
  private Item item;

  //instead of: private int CategoryId;
  @OneToMany
  private Category category;

  //instead of: private int LocalId;
  @OneToMany
  private Local local;