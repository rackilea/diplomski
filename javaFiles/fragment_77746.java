@GET
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public List<Eintrag> fetchEntries(@QueryParam("loaded") String loaded) {
    ...
}