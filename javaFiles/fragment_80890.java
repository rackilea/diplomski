@Path("/matches")
public class MatchResource {
    private MatchService matchService = new MatchService();

    @GET
    @Path("/byteam")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Match> getTeamMatches(@PathParam("teamUri") String teamUri) {
        return matchService.getTeamMatches(teamUri);
    }

    @GET
    @Path("/byround")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Match> getRoundMatches(@PathParam("roundUri") String roundUri) {
        return matchService.getRoundMatches(roundUri);
    }
}