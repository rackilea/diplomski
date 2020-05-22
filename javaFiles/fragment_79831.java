@Entity
public class Person {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy="person")
    private Set<PersonName> names;