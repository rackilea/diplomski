@Entity
public class States extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Constraints.Required(message = "stateName cannot be null")
    @Column(nullable = false)
    private String statename;

    @Column(nullable = true)
    private String url;

    @Column(nullable = true)
    private String parent;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Children> childrenList;
}