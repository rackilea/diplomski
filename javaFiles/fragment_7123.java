@Entity
public class EntityOne {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany(mappedBy = "entity", cascade=CascadeType.ALL)
    private Set<EntityTwo> entities = new HashSet<EntityTwo>();
    public EntityOne(String name) {
        this.name = name;
    }
    public void addEntity(EntityTwo entity) {
        this.entities.add(entity);
    }
    // Default constructor, setters & getters
}