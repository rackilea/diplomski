import javax.persistence.*;

@Entity
@Table(name = "Squads")
public class Squad{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    public int id;

    @Column(name = "SquadName", nullable = false)
    private String squadName;

    @Column(name = "SquadDescription", nullable = false)
    private String squadDescription;

    @Column(name = "PrimaryFormation", nullable = false)
    private String primaryFormation;

    public Squad(){

    }

    public Squad(final String squadName, final String squadDescription, final String primaryFormation){

        this.squadName = squadName;
        this.squadDescription = squadDescription;
        this.primaryFormation = primaryFormation;
    }

    public int getId(){

        return id;
    }

    public void setId(final int id){

        this.id = id;
    }

    public String getSquadName(){

        return squadName;
    }

    public void setSquadName(final String squadName){

        this.squadName = squadName;
    }

    public String getSquadDescription(){

        return squadDescription;
    }

    public void setSquadDescription(final String squadDescription){

        this.squadDescription = squadDescription;
    }

    public String getPrimaryFormation(){

        return primaryFormation;
    }

    public void setPrimaryFormation(final String primaryFormation){

        this.primaryFormation = primaryFormation;
    }
}