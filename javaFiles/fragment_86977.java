@Entity
public class Child {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "parentId")
    private Parent parent;
    // Remove parentId field

    // Getters + Setters ...
}