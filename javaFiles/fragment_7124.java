@Entity
public class EntityTwo {
    @Id
    @GeneratedValue
    int id;
    String name;
    @ManyToOne
    @JoinColumn(name = "entity_one_id")
    private EntityOne entity;
    public EntityTwo(String name) {
        this.name = name;
    }
    // Default constructor, setters & getters
}