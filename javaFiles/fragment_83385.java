@Entity
public class Foo {

  @JsonIgnore
  @ManyToMany
  private Set<Bar> barSet;

  @JsonIgnore
  @OneToMany
  private Set<Zzz> zzzSet;
}