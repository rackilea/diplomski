@Path("/teams")
public class TeamResource {
    TeamService teamService = new TeamService();

    @Path("/{teamUri}/matches")
    public MatchResource getMatchResource() {
        return new MatchResource();
    }
}