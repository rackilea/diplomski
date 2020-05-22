@Root(name = "Tournaments")
@Convert(TournamentsConverter.class) // Specify the Converter used for this class
public class Tournaments
{
    private Map<String, List<Tournament>> tournaments;

    public Tournaments()
    {
        tournaments = new HashMap<>();
    }


    protected void put(String id, List<Tournament> tournaments)
    {
        this.tournaments.put(id, tournaments);
    }

    // ...
}