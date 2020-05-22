@Entity
public class Maschine implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int maschine_id  ;
  private String name ;
  private String description ;
  @OneToMany(mappedBy="maschine")
  private Collection<Characteristic> characteristics;
public Maschine() {
    super();
    // TODO Auto-generated constructor stub
}
public int getMaschine_id() {
    return maschine_id;
}
public void setMaschine_id(int maschine_id) {
    this.maschine_id = maschine_id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}