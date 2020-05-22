@Entity
@Table(name = "player_stat")
public class PlayerStat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int performance;

    @OneToOne
    @JoinColumn(name = "squad_player_id")
    private SquadPlayer squadPlayer;
    ...
}