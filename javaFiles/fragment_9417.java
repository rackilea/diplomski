@Entity
@Table(name = "PARENT")
public class Parent { // better name will do the job, because parent is often called
                      // the higher level class of the same hierarchy
  @Id
  @GeneratedValue
  @Column(name = "PARENT_ID")
  private long id;

  @Column(name = "SOME_VALUE") //if you need to persist it
  private int someValue1;

  @OneToOne(optional = false, cascade = CascadeType.ALL)
  @JoinColumn(name = "FK_PARENT_ID")
  private ChildType child;

  // getters and setters
}