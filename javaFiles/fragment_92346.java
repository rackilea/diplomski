@Entity
@Table
public class A implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany
    @JoinTable(name="a_b", 
        joinColumns = @JoinColumn(name = "a_id", nullable = false), 
        inverseJoinColumns = @JoinColumn(name = "b_id", nullable = false)
    )
    private List<B> bList = new ArrayList<B>();
}

---------------------------------------------------------------------------------

@Entity
@Table
public class B implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany
    @JoinTable(name="a_b", 
        joinColumns = @JoinColumn(name = "b_id", nullable = false), 
        inverseJoinColumns = @JoinColumn(name = "a_id", nullable = false)
    )
    private List<A> aList = new ArrayList<A>();
}