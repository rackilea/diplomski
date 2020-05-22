String json = new Gson().toJson(plans);

@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/getplans/{type}")
public String GetAllPlans(@PathParam("type") String type) {

    PlanDAO dao = new PlanDAO();
    ArrayList<UserPlan> plans = dao.GetAllPlans_ByType(type);

    return new Gson().toJson(plans);
}