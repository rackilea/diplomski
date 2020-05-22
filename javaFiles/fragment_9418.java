@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ChildType { // this one is actually called parent class

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  @Column(name = "CHILDTYPE_ID")
  protected Long id;

  @Column(name = "SOME_VALUE_2")
  private int someValue2; // or maybe protected. Depends if you need childs to access it

  @Column(name = "A_STRING")
  private String string; // or maybe protected. Depends if you need childs to access it

  // getters and setters
}