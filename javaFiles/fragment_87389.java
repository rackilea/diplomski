public class Entity1 {

  @OneToMany(mappedBy="entity1")
  private List<Association> associations = new ArrayList<Association>();
  ...
}