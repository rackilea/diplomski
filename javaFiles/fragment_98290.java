@entity
public class Person
{
    @EmbeddedId
    private PersonPK key;

    @Column(name="p_post_code", nullable = false)
    private String  p_post_code;

    //....
}

@Embeddable
public class PersonPK
{
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="p_id");
    private Long p_id;

    @Column(name="p_name")
    private String p_name;

    public PersonPK(String name)
    {
        p_name = name;
    }

    //....
}