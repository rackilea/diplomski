@Entity
class Person
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Person_Friends")
    List<Person> friends = new ArrayList<>();

    @Override
    public String toString() {
        return "Person [id=" + id + ", friends=" + friends + "]";
    }
}