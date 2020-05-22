@Entity
class User {

    @Id
    private String name;

    @OneToMany
    private Set<Product> products;

}