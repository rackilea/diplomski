@JsonIgnoreProperties("team_id")
@JsonNamingStrategy(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy)
public class Registration implements Serializable 
{
    private static final long serialVersionUID = 1L;

    private int id;
    private String currentStatus;
    private Date expirationTime;

    @JsonIgnore
    private Volunteer volunteer;
    @JsonIgnore
    private Team team;

    public Registration() {        
    }

    // other code
}