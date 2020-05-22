@POST
@Path("create2")
@Consumes("application/json")
public String create(Agent entity) throws SQLException {

    AgentDAO agents = new AgentDAO();
    agents.insertAgent(entity);
    return "Successfully created";
}