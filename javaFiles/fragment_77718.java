@Entity
@Table(name="squad")
public class Squad {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    private String name;
    private String description;
    private String primaryFormation;

    @OneToMany(mappedBy = "squad", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<SquadPlayer> playerSet = new HashSet<>();

    ...
 }