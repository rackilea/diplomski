@Entity
@Table(name = "PARENT_TABLE")
public class Parent {
  @Id private Long id;

  @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST)
  private Collection<Child> children;

  public void addChild(Child child) {
    if (children == null) {
      children = new ArrayList<Child>();
    }
    child.setParent(parent);
    children.add(child);
  }
}

@Entity
@Table(name = "CHILD_TABLE")
public class Child {
  @Id private Long id;

  @ManyToOne
  private Parent parent;

  public void setParent(Parnet parent) {
    this.parent = parent;
  }
}

Parent parent = // build or load parent
Child child = // build child
parent.addChild(child);