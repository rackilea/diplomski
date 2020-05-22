@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String naam;
    private String omschrijving;
    private double prijs;
    @OneToMany(mappedBy = "product_m")
    private List<Aanbieding> aanbiedingen;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "product_categories", 
        joinColumns = { @JoinColumn(name = "product_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "categorie_id") }
    )
    private List<Categorie> categories;
}

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categorie_id;
    private String naam;
    private String omschrijving;

    @ManyToMany(mappedBy = "categories")
    private List<Product> producten;

}