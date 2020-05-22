@Path("/rounds")
public class RoundResource {
  RoundService roundService = new RoundService();

    @Path("{roundUri}/matches")
    public MatchResource getMatchResource() {
        return new MatchResource();
    }
}