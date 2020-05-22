@Entity
@Table(name = "squad_player")
public class SquadPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "generic_player_id")
    private int genericPlayerId;

    @ManyToOne
    @JoinColumn(name = "squad_id")
    private Squad squad;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @OneToOne(mappedBy = "squadPlayer", orphanRemoval = true, cascade = CascadeType.ALL)
    private PlayerStat playerStat;

    ...
}