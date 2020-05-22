@Entity
public class Foo {

  @ManyToMany(fetch = FetchType.EAGER)
  private Set<Bar> barSet;

  @OneToMany(fetch = FetchType.EAGER)
  private Set<Zzz> zzzSet;
}