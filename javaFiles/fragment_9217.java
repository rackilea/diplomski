@Entity
class A {
  @Id
  private int b;
  @Id
  private int c;
}

@Embeddable
class BKey {
  private int a;
  private int b;
}

@Entity
class B {
  @EmbeddedId
  private BKey primaryKey;

  @MapsId("b")
  @ManyToOne(optional = false)
  @JoinColumns(value = {
          @JoinColumn(name = "b", referencedColumnName = "b"),
          @JoinColumn(name = "c", referencedColumnName = "c") })
  private A entityA;
}