@entity
public class Person
{
    @EmbeddedId
    private PersonPK key;

    @MapsId(value="p_name_id")
    @ManyToOne
    @JoinColumn(name = "p_name_id", referencedColumnName = "id")
    private Name p_name;

    @Column(name="p_post_code", nullable = false)
    private     String  p_post_code;

    //....
}

@Embeddable
public class PersonPK
{
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="p_id");
    private Long p_id;

    @Column(name="p_name_id")
    private Long p_name_id;

    public PersonPK(Name name)
    {
        p_name_id = name.getId();
    }

    //....
}

@Entity
public class Name
{
    @Id
    @GeneratedValue(some generation strategy here)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    //....
}