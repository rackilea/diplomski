@Entity
public class A {
  @Id
  @Access(AccessType.PROPERTY)
  private int id;

  @OneToMany(fetch=LAZY)
  private List<B> list;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}