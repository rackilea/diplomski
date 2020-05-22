@Entity
class A {
  @Id
  private int b;
  @Id
  private int c;
}

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = { "a", "b" }) })
class B {
  @Id
  private int a;

  @Id
  @ManyToOne(optional = false)
  @JoinColumns(value = {
          @JoinColumn(name = "b", referencedColumnName = "b"),
          @JoinColumn(name = "c", referencedColumnName = "c") })
  private A entityA;
}