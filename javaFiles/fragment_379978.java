@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @ManyToMany(mappedBy = "persons", cascade=CascadeType.ALL) 
    private Collection<Function> functions;

    // .. getters and setters

@Entity
@Table(name = "FUNC")
public class Function {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "function_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "PERSON_FUNC",
    joinColumns = {@JoinColumn(name = "function_id", referencedColumnName = "id")}, 
    inverseJoinColumns = {@JoinColumn(name = "person_id", referencedColumnName = "id")}) 
    private Collection<Person> persons;

    // .. getters and setter