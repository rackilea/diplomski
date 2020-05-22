@Entity
public class Parent {
    @Id
    private Integer id;
    @OneToMany(mappedBy = "parent") // Change this
    private List<Child> children;

    // Getters + Setters ...
}