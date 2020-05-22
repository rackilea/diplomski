@Entity
public class Foo {

  @JsonManagedReference
  @OneToMany
  private Set<Zzz> zzzSet;