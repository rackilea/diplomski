@Entity
@Table(name = "object")
@Inheritance(strategy = InheritanceType.JOINED)
public class ObjectClass {
    @Id @GeneratedValue 
    private Long id;

    public ObjectClass() { }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}