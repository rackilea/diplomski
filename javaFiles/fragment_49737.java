@Entity
@Table(name="player_ship")
@FilterDef(name="active", parameters=@ParamDef(name="active",type="java.lang.Boolean"))
public class PlayerShip {
    /*...*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pilot_id")
    private Pilot pilot;
    /*...*/
}