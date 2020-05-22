@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String position;
    private String country;
    private String club;

    @OneToMany(mappedBy = "player")
    private Set<SquadPlayer> squadSet = new HashSet<>();

    ....
}