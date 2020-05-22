@Entity
public class Product {

    @Id
    @GeneratedValue
    private UUID id;

    // TODO names should contain at least one non-null value
    @ElementCollection
    @MapKeyColumn(name="lan", length=2)
    @Column(name="name")
    @Size(min=1)   // <- This is all that's needed to implement what you're asking
    @NotEmpty  // Also implies not-null - for >= 1, this line alone is sufficient
    Map<String,String> names;

    protected Product() {}
    public Product(Map<String, String> names) {
        this.names = names;
    }

}